package crm

import grails.converters.JSON

class WSController {

    def index() {
        render "Escriba la URL completa que se le proporciono para el WS"
    }

    //Ws lista de clientes para el señor José Hugo
    def serverclilist(){
        //def cli = new SOAPClient('localhost:8080/crm/empresa/serviceLisCli')
        //Lista de Clientes solo Nit y Razon Social
        def consul = "select nit, razonSocial from Empresa"
        def con = Empresa.executeQuery(consul)
        //def jsonCon = JSON.parse(con)
        //def resp = cli.send(con)
        render con as JSON
        println(con)
    }
}
