
def homeDir = "/Users/r.rudenko"
def ideaEvalFolder = homeDir + "/Library/Application Support/JetBrains/IntelliJIdea2020.3/eval"
def ideaOptionFolder = homeDir + "/Library/Application Support/JetBrains/IntelliJIdea2020.3/options"
def javaUserPref = homeDir + "/.java/.userPrefs"
def javaUserPrefJetbrains = javaUserPref + "/jetbrains"

println "Result of deleting $ideaEvalFolder : " + new File(ideaEvalFolder).deleteDir()

def optionXml = new File(ideaOptionFolder, 'other.xml')
def wr = optionXml.filterLine {line ->
    !line.contains('evlsprt')
}
optionXml.write(wr.toString())

println "Deleted evlprt line in other.xml"

println "Result of deleting $javaUserPrefJetbrains : " + new File(javaUserPrefJetbrains).deleteDir()

println "Result of deleting prefs.xml in $javaUserPref : " + new File(javaUserPref, "prefs.xml").delete()





/*
Теперь надо удалить записи из одного файла plist, который хранится в закодированном виде.
Придется его для начала сконвертировать в текст а потом обратно:

cd ~/Library/Preferences
plutil -convert xml1 com.apple.java.util.prefs.plist
sed -i'' -e '/evlsprt/d' com.apple.java.util.prefs.plist
plutil -convert binary1 com.apple.java.util.prefs.plist

 */



