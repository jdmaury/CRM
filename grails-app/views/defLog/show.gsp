<%@ page import="crm.DefLog" %>
<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="detalle">
        <g:set var="entityName" value="${message(code: 'defLog.label', default: 'DefLog')}" />
        <title><g:message code="default.edit.label" args="[entityName]" /></title>
    </head>
    <body>
         <%--<h2>Ver Definición de Auditoria</h2>--%>
         <hr style="margin-top:10px;margin-bottom:10px;">  
        <div id="edit-defLog" class="content scaffold-edit" role="main">            
            <g:form class="form-horizontal" >

                <fieldset class="form">
                    <g:render template="acciones_r" />
                    <br><br>                   
                    <g:set var="xronly" value="true" scope="request"/>                   
                    <g:render template="form"/>
                </fieldset>

            </g:form>
        </div>
    </body>
</html>
