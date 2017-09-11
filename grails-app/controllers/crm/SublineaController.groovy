package crm
import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class SublineaController extends BaseController{

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def generalService

    def index(Integer max) {
        int itemxview=generalService.getItemsxView(0)
        params.max = Math.min(max?: itemxview, 100)
        String  xoffset=params.offset?:0

        def query="from Sublinea  where linea.id='${params.id}' and  eliminado=0 order by descSublinea"
        def queryc="Select count(s) from Sublinea s where s.linea.id='${params.id}' and  s.eliminado=0"
        
        def sublineaInstanceList=Sublinea.findAll(query,[max:params.max,offset:xoffset.toLong()])
        def xnum = Sublinea.executeQuery(queryc)
        respond sublineaInstanceList, model:[sublineaInstanceCount:xnum[0],
                                             xtitulo:generalService?.getValorParametro('sublinet01')]
    }

    def listarBorrados(Integer max) {

        int itemxview=generalService.getItemsxView(0)
        params.max = Math.min(max ?: itemxview, 100)
        String  xoffset=params.offset?:0

        def query="from Sublinea  where eliminado=1 order by descSublinea"
        def sublineaInstanceList=Sublinea.findAll(query,[max:params.max,offset:xoffset.toLong()])

        render view: "index" , model:[sublineaInstanceList:sublineaInstanceList,
                                     sublineaInstanceCount:Sublinea.findAllByEliminado(1),
                                     itemxview:itemxview,xtitulo:generalService?.getValorParametro('sublinet02')]
    }

    def show(Sublinea sublineaInstance) {
        respond sublineaInstance
    }

    @Transactional
    def borrar(Sublinea sublineaInstance) {

        if (params.id == null) {
            notFound()
            return
        }

        sublineaInstance= Sublinea.get(params.long('id'))

        sublineaInstance.eliminado=1

        sublineaInstance.save flush:true

        request.withFormat {
            form {
                //flash.message = message(code: 'default.updated.message', args: [message(code: 'Sublinea.label', default: 'Sublinea'), sublineaInstance.id])
                 redirect url:"/sublinea/index/"+sublineaInstance.linea.id
            }
            '*'{ respond sublineaInstance, [status: OK] }
        }
    }
    def create() {
        respond new Sublinea(params)
    }

    @Transactional
    def save(Sublinea sublineaInstance) {
        
        if (sublineaInstance == null) {
            notFound()
            return
        }
       
        sublineaInstance.linea=Linea.get(params.idlinea)
         sublineaInstance.validate()
       if (sublineaInstance.hasErrors()) {
            respond sublineaInstance.errors, view:'create'
            return
        }

        sublineaInstance.save flush:true

        request.withFormat {
            form {
               // flash.message = message(code: 'default.created.message', args: [message(code: 'sublineaInstance.label', default: 'Sublinea'), sublineaInstance.id])
                redirect url:"/sublinea/index/"+sublineaInstance.linea.id
            }
            '*' { respond sublineaInstance, [status: CREATED] }
        }
    }

    def edit(Sublinea sublineaInstance) {
        respond sublineaInstance
    }

    @Transactional //upsate
    def update(Sublinea sublineaInstance) {
        
        if (sublineaInstance == null) {
            notFound()
            return
        }

        if (sublineaInstance.hasErrors()) {
            respond sublineaInstance.errors, view:'edit'
            return
        }

        sublineaInstance.save flush:true

        request.withFormat {
            form {
                //flash.message = message(code: 'default.updated.message', args: [message(code: 'Sublinea.label', default: 'Sublinea'), sublineaInstance.id])
                redirect url:"/sublinea/index/"+sublineaInstance.linea.id
            }
            '*'{ respond sublineaInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Sublinea sublineaInstance) {

        if (sublineaInstance == null) {
            notFound()
            return
        }

        sublineaInstance.delete flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Sublinea.label', default: 'Sublinea'), sublineaInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sublineaInstance.label', default: 'Sublinea'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
    def infoSublineas(){
        def query="from Sublinea s where s.linea.id='${params.id}' and s.eliminado=0"
        def sublineaList=Sublinea.findAll(query)
        render template:'/sublinea/sublineas', model: [sublineaList:sublineaList]
    }
}
