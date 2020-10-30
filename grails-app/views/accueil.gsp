<!doctype html>
<html>
<head>
    <meta name="layout" content="accueil"/>
    <title>Welcome</title>
    <style>
       body{
    height:100vh;
  }
      .container-accueil{
        width:50%;
        margin:auto;
        display:grid;
        grid-template-columns: repeat(4, 12px);
        /*grid-template-rows: repeat(3, auto);  */
        align-content: flex-start;
        justify-content: space-between; 
        justify-items: center;
      }
      .tittre{
        text-align:center
      }
    </style>
</head>
<body>
    <h3 class="tittre">Choisir un module pour commence</h3>
      <div class="container-accueil">
        <div> 
            <g:link  action="index" controller="etudiant">
                <asset:image src="reading.png" width="100px"/>
                <p>Etudiant</p>
            </g:link>
        </div>
        <div>
            <g:link  action="index" controller="professeur">
                <asset:image src="classroom.png" width="100px"/>
                <p>Professeur</p>
            </g:link>
        </div>
        <div>
            <g:link  action="index" controller="Vehicule">
            <asset:image src="school-bus.png" width="100px"/>
            <p>Transport</p>
            </g:link>
        </div>
        <div>
            <g:link  action="index" controller="Vehicule">
            <asset:image src="web.png" width="100px"/>
            <p>Configuration</p>
            </g:link>
        </div>
        <div>
            <g:link  action="index" controller="Vehicule">
            <asset:image src="admin.png" width="100px"/>
            <p>Adminstration</p>
            </g:link>
        </div>
    </div>
        <br><br>
        
</body>
</html>
