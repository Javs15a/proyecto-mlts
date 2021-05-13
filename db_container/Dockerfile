FROM mysql:8.0.24 as builder
ENTRYPOINT ["docker-entrypoint.sh"]
EXPOSE 3306 3317
CMD ["mysqld"]
RUN ["sed", "-i", "s/exec \"$@\"/echo \"not running $@\"/", "/usr/local/bin/docker-entrypoint.sh"]

# needed for intialization
ENV MYSQL_ROOT_PASSWORD=root

COPY db_store.sql /docker-entrypoint-initdb.d/

RUN ["/usr/local/bin/docker-entrypoint.sh", "mysqld", "--datadir", "/initialized-db"]

FROM mysql:8.0.24

COPY --from=builder /initialized-db /var/lib/mysql
