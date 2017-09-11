<%@ page import="crm.Producto" %>
<!DOCTYPE html>
<html>
    <head>
        <g:if test="${params.layout=='detail'}" >
            <g:set var="xlayout" value="detalle"  />
        </g:if>
        <g:else>
            <g:set var="xlayout" value="perfectum"  />
        </g:else>
        <meta name="layout" content="${xlayout}">
        <g:set var="entityName" value="${message(code: 'producto.label', default: 'Producto')}" />
        <title><g:message code="default.edit.label" args="[entityName]" /></title>
    </head>
    <body>

        <div id="edit-producto" class="content scaffold-edit" role="main">
            <h2>Editar Producto </h2>            
            <hr style="margin-top:10px;margin-bottom:10px;">                           

            <g:if test="${flash.message}">
                <div class="message" role="status">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${productoInstance}">
                <ul class="errors" role="alert">
                    <g:eachError bean="${productoInstance}" var="error">
                        <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
                        </g:eachError>
                </ul>
            </g:hasErrors>
            <g:form  class="form-horizontal" url="[resource:productoInstance, action:'update']" method="PUT" >
                <g:render template="acciones" />
                <br>
                <br>
                <fieldset class="form">
                    <g:set var="xronly" value="false" scope="request"/>
                    <g:render template="form"/>
                </fieldset>
                <fieldset class="buttons">
                </fieldset>
            </g:form>
        </div>
    </body>
</html>
