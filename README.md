# TP ANDROID TV (ESGI 4MOC)
Moussa OUDJAMA - Cindy NGUYEN - Yannis MEKAOUCHE


## Découvrir le projet
**Alors que nous n'avons pas encore fait les modifications pour une compatibilité Android TV, pourquoi l'application arrive-t-elle à se lancer ?**
<br>
=> Les applications TV utilisent la même structure que les applications mobiles et tablettes.
Cette similitude signifie que nous pouvons modifier une application existante sur une télévision ou créer de nouvelles apps basées sur nos connaissances en développement d’application pour Android

**Des éléments ont-ils changé ?**
<br>
=> La bannière, qui nous provenait du thème précédent, a disparu, le style graphique des éléments a changé. On se retrouve avec un écran vide.

## Afficher des listes (2/2)
**Que se passe-t-il si on n'appelle pas startEntranceTransition() après un prepareEntranceTransition() ?**
<br>
=> Si la fonction startEntranceTransition() n’est pas appelée après un prepareEntranceTransition(), la progress bar tourne indéfiniment, bloquant ainsi l’accès à l’écran (même si les résultats sont en vérité déja fetch, derrière..). 

## Afficher une popup
**Cela fonctionne-t-il ? Si oui, qu'en est-il de l'ergonomie ?**
<br>
=> Oui ça fonctionne, mais ce n’est pas très ergonomique, tout d’abord ce n’est pas très pratique de naviguer avec une télécommande au niveau de la pop-up,
ce n’est pas très clair au moment de l’affichage. Ce type d’affichage semble beaucoup plus propice aux formats mobile et web.


**Qu'est-ce qui s'affiche à l'écran ?**
<br>
=> Ci-dessous un screenshot du résultat à l'écran. On distingue la structure de ce layout, avec la partie pour les questions à gauches, et celle pour les réponses, à droite.
https://ibb.co/hHvQcrQ

**Que se passe-t-il si vous cliquez sur l'un des deux sous-choix ?**
<br>
=> La sous fenêtre contenant les subactions se ferme, après en avoir sélectionné une.







