#!/usr/bin/env sh
# ... (standard Apache license header)
# ... (directory resolution logic)
APP_HOME="`pwd`"
# ... (JVM options and OS detection)
CLASSPATH=$APP_HOME/gradle/wrapper/gradle-wrapper.jar
# ... (Java command detection and file descriptor setup)
# ... (Cygwin path conversion)
# Execute Gradle
exec "$JAVACMD" $DEFAULT_JVM_OPTS $JAVA_OPTS $GRADLE_OPTS "$@"
