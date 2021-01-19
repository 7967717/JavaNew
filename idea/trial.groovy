
def homeDir = "/home/roman"
def ideaEvalFolder = homeDir + "/.config/JetBrains/IntelliJIdea2020.1/eval"
def ideaOptionFolder = homeDir + "/.config/JetBrains/IntelliJIdea2020.1/options"
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