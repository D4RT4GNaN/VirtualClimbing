INSERT INTO public.identified_user 
	(pseudo, first_name, last_name, password, registration_date)
VALUES
	('Frankie', 'Franck', 'Bernard', 'motdepasse', CURRENT_TIMESTAMP),
	('Max', 'Maxime', 'Blaise', 'motdepasse', CURRENT_TIMESTAMP),
	('Anonymous', 'FirstName', 'LastName', 'password', CURRENT_TIMESTAMP);
	
INSERT INTO public.topo 
	(name, official_web_site, description, pseudo, image_url, private, number_site)
VALUES
	('Colima100', 'https://www.ffme974.org/2014/07/nouveau-site-colima-100-topo/', 
	 'Vous lattendiez ?
	 Vous vouliez faire de nouvelles voies pendant vos vacances ?
	 Franckie cest décarcassé pour vous et vous offre le topo des nouvelles voies équipées dans la ravine des Colimaçons ! Un grand merci à lui !!
	 Profitez-bien, et noubliez-pas que le port du casque est toujours recommandé, encore plus sur de nouvelles voies qui, malgré leffort de purge fait par les ouvreurs, peuvent tj révéler quelques surprises ',
	'Frankie','images/colima100Topo/banner_topo_colima100.jpg', false, 1),
	('Le désert des Froussard', 'https://climbingaway.fr/fr/site-escalade/le-desert-des-froussards', 'Petite falaise idéale pour lété dans le bois des Vouillands, loin du vacarme de la ville, à lombre dès 13h. 
	 Une marche dapproche juste ce quil faut pour séchauffer, et vous voilà au pied dun mur dune cinquantaine de mètres de long, pourvu dun beau calcaire gris et blanc.',
	'Anonymous', 'images/froussardTopo/banner_topo_froussard.jpg', false, 1),
	('Ceuse', 'https://climbingaway.fr/fr/site-escalade/ceuse', 'Autrefois surnommée "La falaise de Patrick Edlinger", encore considérée aujourd''hui par beaucoup comme "La plus belle falaise du monde", Céüse fait rêver les grimpeurs depuis des décennies. 
	 Si les meilleurs grimpeurs internationaux s''y délectent dans les voies du 7ème, 8ème et 9ème degré, des voies plus accessibles en 6 y ont été récemment équipées pour le plus grand bonheur de tous.
	 Il existe aussi à Céüse quelques grandes voies et des voies en terrain d''aventure.',
	 'Anonymous', 'images/froussardTopo/banner_topo_froussard.jpg', true, 2);
	 
INSERT INTO public.site
	(name, image_url, latitude, longitude, location, access, rock_type, profil, anchorage, max_height, min_altitude, orientation, note, number_sector)
VALUES
	('Colima 100', 'images/colima100Topo/banner_topo_colima100.jpg', -21.1525000, 55.2825000, 'Ravines Colimaçons - île de la Réunion', '10 minutes de marche dans la ravine jusqu''au chemin rubalisé', 'volcanique', 
	'Verticale, Dièdre, Dalle', 'Type COLLINOX scéllés', 20, 100, 'SUD', 'Toute la journée à l''ombre et dans le vent, Idéal', 3),
	('Céüse', 'images/ceuseTopo/banner_topo_ceuse.jpg', 44.4966, 5.9441, 'France, Provence-Alpes-Côte d''Azur, Hautes-Alpes (05), Gap, Sigoyer', 'entre 45 et 1h15 min en montée raide.', 'Calcaire',
	 'Vertical, dévers, dalle', 'Trous et réglettes', 130, 1750, 'OUEST, SUD-OUEST, SUD, SUD-EST, EST', 'Autrefois surnommée "La falaise de Patrick Edlinger", encore considérée aujourd''hui par beaucoup comme "La plus belle falaise du monde", Céüse fait rêver les grimpeurs depuis des décennies. Si les meilleurs grimpeurs internationaux s''y délectent dans les voies du 7ème, 8ème et 9ème degré, des voies plus accessibles en 6 y ont été récemment équipées pour le plus grand bonheur de tous.
	 Il existe aussi à Céüse quelques grandes voies et des voies en terrain d''aventure.', 1),
	('Céüse (blocs)', 'images/ceuseTopo/banner_topo_ceusebloc.jpg', 44.493599, 5.96472, 'France, Provence-Alpes-Côte d''Azur, Hautes-Alpes (05), Gap, Sigoyer', 'entre 2 et 10 min sur du plat', 'Calcaire',
	 'Vertical, dièdre, dalle, surplomb', 'Réglettes, gouttes d''eau, fissures, cannelures et àplats', 15, 1300, 'Toutes', 'Quelques blocs trop haut ont été équipés.', 1),
	('Le desert des Froussard', 'images/froussardTopo/banner_topo_froussard.jpg', 45.182109, 5.671996, 'France, Auvergne-Rhône-Alpes, Isère (38), Grenoble, Seyssinet-Pariset.', '20 min en montée facile.', 'Silex, Calcaire',
	 'Vertical, dévers, dalle', 'Réglettes', 17, 600, 'NORD-EST', 'Petite falaise idéale pour lété dans le bois des Vouillands, loin du vacarme de la ville, à lombre dès 13h. Une marche dapproche juste ce quil faut pour séchauffer, et vous voilà au pied dun mur dune cinquantaine de mètres de long, pourvu dun beau calcaire gris et blanc.
	 Ne pas grimper pendant la période de chasse ! (de mi-septembre à fin février)', 2);
	 
INSERT INTO public.topo_site
	(name_topo, name_site)
VALUES
	('Colima100', 'Colima 100'),
	('Le désert des Froussard', 'Le desert des Froussard'),
	('Ceuse', 'Céüse'),
	('Ceuse', 'Céüse (blocs)');
	
/** For site Colima 100 */
INSERT INTO public.sector
	(name, name_site, image_url, number_route)
VALUES
	('DUNES', 'Colima 100', 'images/colima100Topo/colima100/banner_dunes.jpg', 19),
	('SDF', 'Colima 100', 'images/colima100Topo/colima100/banner_sdf.jpg', 8),
	('FICUS', 'Colima 100', 'images/colima100Topo/colima100/banner_ficus.jpg', 9);

/** For site Le désert des Froussard */
INSERT INTO public.sector
	(name, name_site, image_url, number_route)
VALUES
	('Secteur 1', 'Le desert des Froussard', 'images/781x250.svg', 3),
	('Secteur 2', 'Le desert des Froussard', 'images/781x250.svg', 4);
	
/** For site Céüse */
INSERT INTO public.sector
	(name, name_site, image_url, number_route)
VALUES
	('Céüse 1', 'Céüse', 'images/781x250.svg', 4);
	
/** For site Céüse (blocs) */
INSERT INTO public.sector
	(name, name_site, image_url, number_route)
VALUES
	('Céüse (blocs) 1', 'Céüse (blocs)', 'images/781x250.svg', 3);

/** Sector DUNES */
INSERT INTO public.route
	(name, grade, height, note, name_sector)
VALUES
	('Jabba the Hutt', '6b', 15, E'Voie obèse, des plis sur le ventre, Position en dalle popularisée dans les années 1980 dans le crux, équipée la veille d\'un « Jedi », ... on dirait question pour un champion', 'DUNES'),
	('Mano négra', '5a', 15, '1 mètre cube de terre descendu de la fissure, de quoi se salir les pattes! Et un groupe atypique...', 'DUNES'),
	('khjlhlmhlh', '6a', 15, '', 'DUNES'),
	('Théorème', '7b', 15, 'Belle ligne, une vire à protéger, un mousquetonage difficile, un équipement à réfléchir, 2 lignes qui se croisent, mathématiquement compliquée...', 'DUNES'),
	('Diago folle', '5b', 15, E'Ligne évidente, un clin d\'oeil au trailer responsable de l\'équipement des sites de la région qui me fournit en matos...', 'DUNES'),
	('Belle de nuit', '6b', 15, 'Ouverte il y a 20 ans par J-Marc Caron avec un léger abus du perfo, ... une autre époque, une belle ligne, à faire !', 'DUNES'),
	('Liane folie', '6a', 15, 'Ha cette liane, interrogation: coupe, coupe pas, soyons fou !!!', 'DUNES'),
	('Plomb en biais', '7a/6c', 15, 'Une canalisation « lianesque » trop belle pour être coupée, un vol à se mettre de travers, ouarf trop drôle, tout trouvé !', 'DUNES'),
	('Squamate', '7/8', 15, 'Ligne dantesque, projet ambitieux, début de voie en écart/opposition, reptile à écailles qui change régulièrement de peau, si tu en es...', 'DUNES'),
	('Prix à prisme', '8a', 15, E'Phantasmée pendant des jours de terrassement par un prof de math (Yvan), angulaire, le salut du pas de bloc de départ est dans le prisme... Je bande (priaprisme) pour cette voie. Merci à Thierry Caillot pour la validation du projet. Et oui, je n\'ai pas encore ce niveau... ;-)', 'DUNES'),
	('Archange', '7a/7b', 15, E'Une arche évidente pour s\'envoler... de toute beauté, variante: essayer sans les arêtes à partir du 5ème point (7b+) qu\'est-ce qu\'on rigole !', 'DUNES'),
	('Théorie quantique', '7/8', 15, 'Projet, Une ligne qui fait rêver, au-delà de la physique traditionnelle, en théorie « faisable » mais pas encore observée...', 'DUNES'),
	(E'Ta dû l\' faire', '7a/7c', 15, E'Oui, oui, elle est facile ! A l\'origine « yo c mythique » récemment ouverte sur 3 Bass, variante: la dalle sans l\'arête 4ème pt, old school, proposée 7c', 'DUNES'),
	('Callipyge', '7b', 15, 'Belle croupe arrondie, lisse, old school, en hommage à mes lectures « SAS »ienne du siècle dernier, ha ce « Malko Linge » quel fripon...', 'DUNES'),
	('123', '6c', 15, 'Mono, bi, tri... Vous comprendrez, une fois dedans !', 'DUNES'),
	('Coup de sang', '7a', 15, E'Ou l\'art de s\'éclater le doigt avec l\'ampoule lors du scellement d\'un point...', 'DUNES'),
	(E'L\'Antre deux', '6b', 15, E'Entre deux mon coeur balance, au dernier point, rester dans la dalle dans l\'axe du relais à gauche de l\'arête, à droite c\'est du « 5 », bande de petits malins', 'DUNES'),
	('Vague à lames', '6a', 15, 'Des vagues après la vire, des lames après le surplomb... vous comprendrez...', 'DUNES'),
	('Genèse', '5b', 15, E'Toute première voie équipée du secteur, parfaite pour s\'échauffer, tranquillou', 'DUNES');
	
/** Sector SDF */
INSERT INTO public.route
	(name, grade, height, note, name_sector)
VALUES
	('Cashmire', '6c', 15, '', 'SDF'),
	('Coco beach', '5c', 15, '', 'SDF'),
	('Vhemt', '6c', 15, '', 'SDF'),
	('Margouillattack', '7b', 15, '', 'SDF'),
	('SDF', '8a', 15, '', 'SDF'),
	('Geckoland', '7c', 15, '', 'SDF'),
	('Engage toit', '6b', 15, '', 'SDF'),
	('Toit émoi', '6c', 15, '', 'SDF');
	
/** Sector FICUS */
INSERT INTO public.route
	(name, grade, height, note, name_sector)
VALUES
	('STI2D watt des phoques', '5c', 15, '', 'FICUS'),
	('Banana spit', '6b', 15, '', 'FICUS'),
	('Rage against the ficus', '6b', 15, '', 'FICUS'),
	('Cache toit', '6b', 15, '', 'FICUS'),
	('Le fils sûr', '5b', 15, '', 'FICUS'),
	('Choubikette en goguette', '6c', 15, '', 'FICUS'),
	('Fumier de lapin jaune', '6a', 15, '', 'FICUS'),
	('Lucie', '5c', 15, '', 'FICUS'),
	('Zoé', '5c', 15, '', 'FICUS');

/** Sector Secteur 1 */
INSERT INTO public.route
	(name, grade, height, note, name_sector)
VALUES
	('Gobi', '5c', 7, 'Très sec', 'Secteur 1'),
	('Sahara', '6b', 23, 'Très chaud', 'Secteur 1'),
	('Sibérie', '6b', 18, 'Très froid', 'Secteur 1');

/** Sector Secteur 2 */
INSERT INTO public.route
	(name, grade, height, note, name_sector)
VALUES
	('Sami', '5c', 5, 'Faut se faire peur', 'Secteur 2'),
	('Scooby', '7b', 50, 'Vient avec nous', 'Secteur 2'),
	('Scream', '6b', 40, 'Il faut tomber le masque', 'Secteur 2'),
	('Saw', '5b', 10, 'Attention partie coupante', 'Secteur 2');

/** Sector Céüse 1 */
INSERT INTO public.route
	(name, grade, height, note, name_sector)
VALUES
	(E'Les sucettes à l\'anis', '6a', 32, 'Chacun ses goûts', 'Céüse 1'),
	('Pourquoi pas', '7a+', 30, 'Je dirais même plus et pourquoi pas', 'Céüse 1'),
	('Bibendum', '7b+', 62, 'Un bon gros ventre', 'Céüse 1'),
	('Blanches fesses', '7c', 27, 'Vers les étoiles', 'Céüse 1');
	
/** Sector Céüse (blocs) 1 */
INSERT INTO public.route
	(name, grade, height, note, name_sector)
VALUES
	('Bloc A', '5c', 15, 'Un vrai légo', 'Céüse (blocs) 1'),
	('Bloc B', '7b', 15, 'La cour', 'Céüse (blocs) 1'),
	('Bloc C', '6a', 11, E'L\'isoloire', 'Céüse (blocs) 1');
	
INSERT INTO public.comment
	(title, description, pseudo_user, name_sector)
VALUES
	('Premier secteur ouvert', 'Salut, ça y est le premier secteur de Colima 100 est ouvert', 'Frankie', 'DUNES'),
	('Merci Frankie', 'Super! merci Frankie pour ton beau travail !', 'Anonymous', 'DUNES'),
	('****** de ficus', E'J\'ai compris le problème avec le ficus', 'Max', 'FICUS'),
	('Quel belle région', E'De passage dans cette régions, j\'en ai profiter pour essayer ce site. C\'était génial !', 'Anonymous', 'Céüse 1'),
	('Et une longueur de plus', E'C\'est agréable de pouvoir enchainé des longueurs sans trop se prendre la tête.', 'Max', 'Céüse (blocs) 1');
	
INSERT INTO public.booking
	(start_date, end_date, name_topo, pseudo_user)
VALUES
	(CURRENT_TIMESTAMP, '27/09/2019', 'Ceuse', 'Anonymous');