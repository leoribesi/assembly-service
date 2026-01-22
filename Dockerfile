FROM eclipse-temurin:21-jre

WORKDIR /app

COPY build/libs/*.jar app.jar

ENV PORT=8080
ENV JAVA_OPTS="-Xms256m -Xmx512m -XX:+UseG1GC -XX:MaxRAMPercentage=75"

EXPOSE 8080

ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar /app/app.jar"]
