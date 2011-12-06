name := "g3-simplemodeler"

version := "0.1"

scalaVersion := "2.9.1"

retrieveManaged := true

resolvers += Classpaths.typesafeResolver

resolvers += "Local Maven Repository" at "file://"+Path.userHome.absolutePath+"/.m2/repository"

seq(ProguardPlugin.proguardSettings :_*)

proguardOptions += keepMain("org.simplemodeling.SimpleModeler.g3.Main")

// seq(webSettings :_*)

libraryDependencies += "org.simplemodeling" % "SimpleModeler" % "0.3.0"

// libraryDependencies += "org.simplemodeling" % "SimpleModeler" % "0.3.0-SNAPSHOT"

libraryDependencies += "com.google.code.guice" % "guice" % "2.0"

libraryDependencies += "aopalliance" % "aopalliance" % "1.0"

libraryDependencies += "org.slf4j" % "slf4j-api" % "1.5.11"

libraryDependencies += "org.apache.httpcomponents" % "httpcore" % "4.0.1"

libraryDependencies += "org.apache.httpcomponents" % "httpclient" % "4.0.1"

libraryDependencies += "org.apache.httpcomponents" % "httpmime" % "4.0.1"

libraryDependencies += "oauth.signpost" % "signpost-core" % "1.2.1.1"

libraryDependencies += "oauth.signpost" % "signpost-commonshttp4" % "1.2.1.1"

// libraryDependencies += "commons-fileupload" % "commons-fileupload" % "1.2.2"

// libraryDependencies += "commons-io" % "commons-io" % "1.3.2"

libraryDependencies += "org.eclipse.jetty" % "jetty-webapp" % "7.1.4.v20100610"

libraryDependencies += "org.eclipse.jetty" % "jetty-websocket" % "7.1.4.v20100610"

// libraryDependencies += "org.mortbay.jetty" % "jetty" % "6.1.22" % "container" // package-war

seq(com.github.retronym.SbtOneJar.oneJarSettings: _*)

mainClass in oneJar := Some("org.simplemodeling.SimpleModeler.g3.Main")
