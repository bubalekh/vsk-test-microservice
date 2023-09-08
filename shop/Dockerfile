# runtime
FROM eclipse-temurin:11-jre AS runtime
RUN addgroup --system app && \
    adduser --system --home /opt/app --ingroup app app
WORKDIR /opt/app
COPY --chown=app:app target/*.jar /opt/app/app.jar
USER app:app
ENTRYPOINT [ "java", "-jar", "/opt/app/app.jar" ]
