# kotlin-springboot-reactive-resource-usage

A quick comparison of spring boot resource usage with reactive vs traditional methods.

### Method

1. Install some PID-based resource monitoring tool, e.g.: `sdk install visualvm`
2. Start up the monitoring tool.
3. Start a backing database, e.g.: `docker run -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=postgres -e POSTGRES_DB=db -p 5432:5432 -d postgres:16`
4. Build all subprojects: `.gradlew assemble`

#### Traditional MVC

1. Run: `java -jar ./traditional/build/libs/traditional-0.0.1-SNAPSHOT.jar`
2. Attach the monitoring tool to the running JVM.

#### Reactive (Kotlin coroutines)

1. Run: `java -jar ./traditional/build/libs/kotlin-coroutines-0.0.1-SNAPSHOT.jar`
2. Attach the monitoring tool to the running JVM.

#### Reactive (Project Reactor)

1. Run: `java -jar ./traditional/build/libs/project-reactor-0.0.1-SNAPSHOT.jar`
2. Attach the monitoring tool to the running JVM.

#### Testing

1. Start load testing, e.g.: 
   - `ab -n 10000 -c 50 -s 60 http://localhost:8080/api/nextval`
   - `ab -n 10000 -c 50 -s 60 http://localhost:8081/api/nextval`
   - `ab -n 10000 -c 50 -s 60 http://localhost:8082/api/nextval`
2. Results in the monitoring graphs, e.g.:

