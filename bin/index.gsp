<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Welcome to Grails</title>
  
</head>
<body>
<g:if test="${!session.user}">
    <g:render template="login"/>
</g:if>
<g:else>
    <%-- <g:render template="_complement"/> --%>
<%-- < <section class="row colset-2-its">
    <div id="controllers" role="navigation">
        <h2>Available Controllers:</h2>
        <ul>
            <g:each var="c" in="${grailsApplication.controllerClasses.sort { it.fullName } }">
                <li class="controller">
                    <g:link controller="${c.logicalPropertyName}">${c.fullName}</g:link>
                </li>
            </g:each>
        </ul>
    </div>
</div> --%>
</g:else>
  
</body>
</html>
