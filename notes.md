## Observations

lancement front & back : ok

erreur lors la création du dockerfile (front) :
  ```bash
  => ERROR [build 4/5] RUN yarn                                                                                                       0.1s
  ------
   > [build 4/5] RUN yarn:
  0.120 /bin/sh: 1: yarn: not found
  ------
  
   2 warnings found (use docker --debug to expand):
   - FromAsCasing: 'as' and 'FROM' keywords' casing do not match (line 1)
   - FromAsCasing: 'as' and 'FROM' keywords' casing do not match (line 9)
  Dockerfile:6
  --------------------
     4 |     COPY ./ /usr/local/app/
     5 |
     6 | >>> RUN yarn
     7 |     RUN npm run build
     8 |
  --------------------
  ERROR: failed to solve: process "/bin/sh -c yarn" did not complete successfully: exit code: 127
  ```

cause du problème : ancienne image Node embarquait Yarn par défaut mais ce n'est plus le cas d'où l'erreur

front utilise la version 14.2 d'angular donc node doit être en version 16 maximum.
https://angular.dev/reference/versions
choix de la version node : 16.20.2-bullseye-slim



Indication d'utiliser : docker run -p 8080:8080 --name bobapp-front -d bobapp-front
mais risque de conflit au niveau du port (back aussi)
