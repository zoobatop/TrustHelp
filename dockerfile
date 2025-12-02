FROM openjdk:17-jdk-slim
WORKDIR /app

# Copiar artefato
COPY target/trusthelp-*.jar app.jar

# Criar diretório de logs
RUN mkdir -p /app/logs

# Variáveis de ambiente padrão
ENV SPRING_PROFILES_ACTIVE=prod
ENV PORT=8080
ENV JWT_SECRET=change-this-in-production
ENV ADMIN_INITIAL_PASSWORD=ChangeMe123!

# Expor porta
EXPOSE 8080

# Health check
HEALTHCHECK --interval=30s --timeout=3s --start-period=40s --retries=3 \
  CMD curl -f http://localhost:8080/api/health || exit 1

# Executar aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]