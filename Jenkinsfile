import org.jenkinsci.plugins.scriptsecurity.scripts.*
import org.jenkinsci.plugins.scriptsecurity.scripts.languages.GroovyLanguage

final ScriptApproval sa = ScriptApproval.get();

sh 'curl -O https://raw.githubusercontent.com/kuisathaverat/test/master/realScript.groovy'
def script = readFile 'realScript.groovy'
ScriptApproval.PendingScript s = new ScriptApproval.PendingScript(script, GroovyLanguage.get(), ApprovalContext.create())


sa.approveScript(s.getHash())

evaluate(script)        
