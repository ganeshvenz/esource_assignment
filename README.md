--Bake Image
docker build -t e-source-assignment:0.0.1 .

--List Image
docker image ls

--Inspect
docker inspect e-source-assignment:0.0.1

--Run
docker run --rm --name=esource e-source-assignment:0.0.1

--Save
docker save -o ./e-source-assignment.tar e-source-assignment:0.0.1

--Load
docker image load --input e-source-assignment.tar

--Run (again)
docker run --rm --name=esource e-source-assignment:0.0.1