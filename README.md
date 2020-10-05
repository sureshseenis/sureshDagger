# sureshDagger
Start the dagger concept is repo
Get Apk with verson and date
App gradle
def date=new Date().format('yyyy_MM_dd_HHmm')
android{
 applicationVariants.all { variant ->
        variant.outputs.all {
            def flavor = variant.name
            def versionName = variant.versionName
            outputFileName = "Emozi_Provider_${flavor}_${versionName}_date_${date}.apk"
        }
    }
}
