plugins {
	java
	id("org.springframework.boot") version "4.1.1"
	id("io.spring.dependency-management") version "1.1.7"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(25)
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation ("org.springframework.boot:spring-boot-starter-thymeleaf")
	implementation("org.projectlombok:lombok")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}
tasks.withType<Test> {
	useJUnitPlatform()
	systemProperty("file.encoding", "UTF-8")
}

tasks.withType<JavaCompile> {
	options.encoding = "UTF-8"
}

tasks.withType<Javadoc> {
	options.encoding = "UTF-8"
}

tasks.bootRun {
	systemProperty("file.encoding", "UTF-8")
	jvmArgs = listOf("-Dfile.encoding=UTF-8", "-Dconsole.encoding=UTF-8")
}

tasks.withType<JavaExec> {
	systemProperty("file.encoding", "UTF-8")
	jvmArgs = listOf("-Dfile.encoding=UTF-8")
}
tasks.bootRun {
	systemProperty("file.encoding", "UTF-8")
	jvmArgs = listOf("-Dfile.encoding=UTF-8", "-Dstdout.encoding=UTF-8", "-Dstderr.encoding=UTF-8")
}
