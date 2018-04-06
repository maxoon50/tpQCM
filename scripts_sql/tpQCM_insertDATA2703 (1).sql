

insert into profil (codeProfil, libelle) values ('100', 'stagiaire');
insert into profil (codeProfil, libelle) values ('101', 'externe');
insert into profil (codeProfil, libelle) values ('102', 'formateur');
insert into profil (codeProfil, libelle) values ('103', 'responsable');
insert into profil (codeProfil, libelle) values ('104', 'administrateur');


insert into promotion (codePromo, libelle) values ('DL127', 'la crème de la crème' );
insert into promotion (codePromo, libelle) values ('CDI666', 'le taupe du taupe' );


insert into utilisateur (nom, prenom, email, password, codeProfil, codePromo) values ('Leroux', 'Marine', 'leroux@gmail.com', '12345','100','CDI666');
insert into utilisateur (nom, prenom, email, password, codeProfil, codePromo) values ('Desfoux', 'Maxime', 'desfoux@gmail.com', '12345','100','DL127');
insert into utilisateur (nom, prenom, email, password, codeProfil, codePromo) values ('Andre', 'Rémi', 'andre@gmail.com', '12345','100','DL127');
insert into utilisateur (nom, prenom, email, password, codeProfil) values ('Externe', 'Jean', 'externe@gmail.com', '12345','101');
insert into utilisateur (nom, prenom, email, password, codeProfil) values ('Formateur', 'Jean', 'formateur@gmail.com', '12345','102');
insert into utilisateur (nom, prenom, email, password, codeProfil) values ('Responsable', 'Jean', 'responsable@gmail.com', '12345','103');
insert into utilisateur (nom, prenom, email, password, codeProfil) values ('Administrateur', 'Jean', 'administrateur@gmail.com', '12345','104');



insert into theme ( libelle) values ('SQL');
insert into theme (libelle) values ('Java');
insert into theme (libelle) values ('Front End');
insert into theme (libelle) values ('PHP');


insert into question (enonce, points, idTheme)values ('quel est la couleur principale du java?', '1', '1');
insert into question (enonce, points, idTheme)values ('qui a inventé le java?', '1', '1');
insert into question (enonce, points, idTheme)values ('que signifie sql?', '1', '2');
insert into question (enonce, points, idTheme)values ('ou est né jean sql?', '1', '2');
insert into question (enonce, points, idTheme)values ('quel est la couleur principale du sql?', '1', '2');
insert into question (enonce, points, idTheme)values ('que signifie Javascript?', '1', '3');
insert into question (enonce, points, idTheme)values ('ou est né jean Javascript??', '1', '3');
insert into question (enonce, points, idTheme)values ('quelle est la meilleure version de Javascript???', '1', '3');
insert into question (enonce, points, idTheme)values ('que signifie php', '1', '3');
insert into question (enonce, points, idTheme)values ('ou est né jean php??', '1', '3');
insert into question (enonce, points, idTheme)values ('quelle est la meilleure version de php?', '1', '3');





insert into proposition ( enonce,estBonne, idQuestion) values ('réponse A', '1', '1');
insert into proposition (enonce,estBonne, idQuestion) values ('réponse B', '0', '1');
insert into proposition ( enonce,estBonne, idQuestion) values ('réponse C', '0', '1');
insert into proposition (enonce,estBonne, idQuestion) values ('réponse D', '0', '1');
insert into proposition ( enonce,estBonne, idQuestion) values ('réponse A', '1', '2');
insert into proposition ( enonce,estBonne, idQuestion) values ('réponse B', '0', '2');
insert into proposition ( enonce,estBonne, idQuestion) values ('réponse C', '0', '2');
insert into proposition ( enonce,estBonne, idQuestion) values ('réponse D', '0', '2');
insert into proposition ( enonce,estBonne, idQuestion) values ('réponse A', '1', '3');
insert into proposition ( enonce,estBonne, idQuestion) values ('réponse B', '0', '3');
insert into proposition ( enonce,estBonne, idQuestion) values ('réponse C', '0', '3');
insert into proposition ( enonce,estBonne, idQuestion) values ('réponse D', '0', '3');
insert into proposition ( enonce,estBonne, idQuestion) values ('réponse A', '1', '4');
insert into proposition ( enonce,estBonne, idQuestion) values ('réponse B', '0', '4');
insert into proposition ( enonce,estBonne, idQuestion) values ('réponse C', '0', '4');
insert into proposition ( enonce,estBonne, idQuestion) values ('réponse D', '0', '4');
insert into proposition ( enonce,estBonne, idQuestion) values ('réponse A', '1', '5');
insert into proposition ( enonce,estBonne, idQuestion) values ('réponse B', '0', '5');
insert into proposition ( enonce,estBonne, idQuestion) values ('réponse C', '0', '5');
insert into proposition ( enonce,estBonne, idQuestion) values ('réponse D', '0', '5');
insert into proposition ( enonce,estBonne, idQuestion) values ('réponse A', '1', '6');
insert into proposition ( enonce,estBonne, idQuestion) values ('réponse B', '0', '6');
insert into proposition ( enonce,estBonne, idQuestion) values ('réponse C', '0', '6');
insert into proposition ( enonce,estBonne, idQuestion) values ('réponse D', '0', '6');
insert into proposition ( enonce,estBonne, idQuestion) values ('réponse A', '1', '7');
insert into proposition ( enonce,estBonne, idQuestion) values ('réponse B', '0', '7');
insert into proposition ( enonce,estBonne, idQuestion) values ('réponse C', '0', '7');
insert into proposition ( enonce,estBonne, idQuestion) values ('réponse D', '0', '7');
insert into proposition ( enonce,estBonne, idQuestion) values ('réponse A', '1', '8');
insert into proposition ( enonce,estBonne, idQuestion) values ('réponse B', '0', '8');
insert into proposition ( enonce,estBonne, idQuestion) values ('réponse C', '0', '8');
insert into proposition ( enonce,estBonne, idQuestion) values ('réponse D', '0', '8');
insert into proposition ( enonce,estBonne, idQuestion) values ('réponse A', '1', '9');
insert into proposition ( enonce,estBonne, idQuestion) values ('réponse B', '0', '9');
insert into proposition ( enonce,estBonne, idQuestion) values ('réponse C', '0', '9');
insert into proposition ( enonce,estBonne, idQuestion) values ('réponse D', '0', '9');
insert into proposition ( enonce,estBonne, idQuestion) values ('réponse A', '1', '10');
insert into proposition ( enonce,estBonne, idQuestion) values ('réponse B', '0', '10');
insert into proposition ( enonce,estBonne, idQuestion) values ('réponse C', '0', '10');
insert into proposition ( enonce,estBonne, idQuestion) values ('réponse D', '0', '10');
insert into proposition ( enonce,estBonne, idQuestion) values ('réponse A', '1', '11');
insert into proposition ( enonce,estBonne, idQuestion) values ('réponse B', '0', '11');
insert into proposition ( enonce,estBonne, idQuestion) values ('réponse C', '0', '11');
insert into proposition ( enonce,estBonne, idQuestion) values ('réponse D', '0', '11');


insert into test(libelle,description,duree,seuil_haut,seuil_bas) values ('developpement en couches JAVA SE','blalblalal',7200,12,9);
insert into test(libelle,description,duree,seuil_haut,seuil_bas) values ('developpement symphony 3','blalblalal',7200,12,9);
insert into test(libelle,description,duree,seuil_haut,seuil_bas) values ('developpement java ee','blalblalal',7200,12,9);
insert into test(libelle,description,duree,seuil_haut,seuil_bas) values ('base de donnees oracle','blalblalal',7200,12,9);

insert into epreuve(dateDedutValidite,dateFinValidite,tempsEcoule,etat,idTest,idUtilisateur)
values(GETDATE(),CONVERT(DATETIME, DATEADD(DAY,10,GETDATE())),0,'EA',1,1);
insert into epreuve(dateDedutValidite,dateFinValidite,etat,idTest,idUtilisateur)
values(GETDATE(),CONVERT(DATETIME, DATEADD(DAY,5,GETDATE())),'EA',1,2);
insert into epreuve(dateDedutValidite,dateFinValidite,etat,idTest,idUtilisateur)
values(GETDATE(),CONVERT(DATETIME, DATEADD(DAY,6,GETDATE())),'EA',1,3);
insert into epreuve(dateDedutValidite,dateFinValidite,tempsEcoule,etat,idTest,idUtilisateur)
values(GETDATE(),CONVERT(DATETIME, DATEADD(DAY,10,GETDATE())),0,'EA',2,1);
insert into epreuve(dateDedutValidite,dateFinValidite,etat,idTest,idUtilisateur)
values(GETDATE(),CONVERT(DATETIME, DATEADD(DAY,5,GETDATE())),'EA',2,2);
insert into epreuve(dateDedutValidite,dateFinValidite,etat,idTest,idUtilisateur)
values(GETDATE(),CONVERT(DATETIME, DATEADD(DAY,6,GETDATE())),'EA',2,3);


insert into SECTION_TEST(nbQuestionsATirer,idTest,idTheme) VALUES (2,1,2);
insert into SECTION_TEST(nbQuestionsATirer,idTest,idTheme) VALUES (2,1,3);
