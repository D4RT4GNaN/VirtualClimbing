
CREATE TABLE public.identified_user (
                pseudo VARCHAR(50) NOT NULL,
                first_name VARCHAR(50) NOT NULL,
                last_name VARCHAR(50) NOT NULL,
                password VARCHAR(256) NOT NULL,
                registration_date DATE NOT NULL,
                CONSTRAINT identified_user_pk PRIMARY KEY (pseudo)
);


CREATE TABLE public.site (
                name VARCHAR(100) NOT NULL,
                image_url VARCHAR(500),
                latitude NUMERIC(10,7) NOT NULL,
                longitude NUMERIC(10,7) NOT NULL,
                location VARCHAR(500) NOT NULL,
                access VARCHAR(500) NOT NULL,
                rock_type VARCHAR(100) NOT NULL,
                profil VARCHAR(500) NOT NULL,
                anchorage VARCHAR(250) NOT NULL,
                max_height INTEGER NOT NULL,
                min_altitude INTEGER NOT NULL,
                orientation VARCHAR(50) NOT NULL,
                note VARCHAR(1000) NOT NULL,
                number_sector INTEGER NOT NULL,
                CONSTRAINT site_pk PRIMARY KEY (name)
);


CREATE TABLE public.sector (
                name VARCHAR(100) NOT NULL,
                name_site VARCHAR(100) NOT NULL,
                image_url VARCHAR(500),
                number_route INTEGER NOT NULL,
                CONSTRAINT sector_pk PRIMARY KEY (name)
);


CREATE SEQUENCE public.comment_ref_seq;

CREATE TABLE public.comment (
                ref INTEGER NOT NULL DEFAULT nextval('public.comment_ref_seq'),
                title VARCHAR(100) NOT NULL,
                description VARCHAR(1000) NOT NULL,
                pseudo_user VARCHAR(50) NOT NULL,
                name_sector VARCHAR(100) NOT NULL,
                CONSTRAINT comment_pk PRIMARY KEY (ref)
);


ALTER SEQUENCE public.comment_ref_seq OWNED BY public.comment.ref;

CREATE TABLE public.route (
                name VARCHAR(100) NOT NULL,
                grade VARCHAR(10) NOT NULL,
                height INTEGER NOT NULL,
                note VARCHAR(1000),
                name_sector VARCHAR(100) NOT NULL,
                CONSTRAINT route_pk PRIMARY KEY (name)
);


CREATE TABLE public.topo (
                name VARCHAR(100) NOT NULL,
                official_web_site VARCHAR(500),
                description VARCHAR(1000) NOT NULL,
                pseudo VARCHAR(50) NOT NULL,
                image_url VARCHAR(500),
                private BOOLEAN NOT NULL,
                number_site INTEGER NOT NULL,
                CONSTRAINT topo_pk PRIMARY KEY (name)
);


CREATE TABLE public.topo_site (
                name_topo VARCHAR(100) NOT NULL,
                name_site VARCHAR(100) NOT NULL,
                CONSTRAINT topo_site_pk PRIMARY KEY (name_topo, name_site)
);


CREATE SEQUENCE public.booking_ref_seq;

CREATE TABLE public.booking (
                ref INTEGER NOT NULL DEFAULT nextval('public.booking_ref_seq'),
                start_date DATE NOT NULL,
                end_date DATE NOT NULL,
                name_topo VARCHAR(100) NOT NULL,
                pseudo_user VARCHAR(50) NOT NULL,
                CONSTRAINT booking_pk PRIMARY KEY (ref)
);


ALTER SEQUENCE public.booking_ref_seq OWNED BY public.booking.ref;

ALTER TABLE public.topo ADD CONSTRAINT user_topo_fk
FOREIGN KEY (pseudo)
REFERENCES public.identified_user (pseudo)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.booking ADD CONSTRAINT user_booking_fk
FOREIGN KEY (pseudo_user)
REFERENCES public.identified_user (pseudo)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.comment ADD CONSTRAINT user_comment_fk
FOREIGN KEY (pseudo_user)
REFERENCES public.identified_user (pseudo)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.sector ADD CONSTRAINT site_sector_fk
FOREIGN KEY (name_site)
REFERENCES public.site (name)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.topo_site ADD CONSTRAINT site_topo_site_fk
FOREIGN KEY (name_site)
REFERENCES public.site (name)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.route ADD CONSTRAINT sector_route_fk
FOREIGN KEY (name_sector)
REFERENCES public.sector (name)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.comment ADD CONSTRAINT sector_comment_fk
FOREIGN KEY (name_sector)
REFERENCES public.sector (name)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.booking ADD CONSTRAINT topo_booking_fk
FOREIGN KEY (name_topo)
REFERENCES public.topo (name)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.topo_site ADD CONSTRAINT topo_topo_site_fk
FOREIGN KEY (name_topo)
REFERENCES public.topo (name)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;
