# CryptoTranscript 


CryptoTranscript deals with Blockchain based digital transcripts to the University or School or Employer. Hence, transcripts values will never get tampered and data will never get lost as well. 


## Prerequisits

[Java Development Kit JDK8](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)


## Running

#### To run this application, follow the below methods:

1. Make sure you have the prerequisits installed
2. Traverse to project directory in terminal / command prompt 
3. Once you are in the project directory, run the command `gradlew run`
4. The warnings and 80% [Executing] can safely be ignored
5. Open the CryptoTranscript.html which is in the parent directory.


## API Information

Once the application is up and running, the API instances are available at http://localhost:4444 and is accessible through postman.

### endpoints

* `GET /getTranscriptBlocks` - lists all existing blocks in the chain
* `POST /transcriptBlocks/mine` - mines a block
* `POST /tamperBlocks` - tampers an existing block
* `POST /transcriptBlocks/fork` - simulates fork
* `GET /transcriptBlocks/longestchain` - finds the longest chain


## References

* [Mango Research](https://www.mangoresearch.co)
* [BlockCerts](https://www.blockcerts.org/guide)

#### This project uses some open source libraries:

* [Apache Commons Codec](https://github.com/apache/commons-codec)
* [Javalin](https://javalin.io/)
* [Jackson Module Kotlin](https://github.com/FasterXML/jackson-module-kotlin)
* [Gradle Build Tool](https://gradle.org/)
