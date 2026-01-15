# SmartLoad Optimization API

## How to run

```bash
docker compose up --build
```

Service will be available at http://localhost:8080

Example request:

```bash
curl -X POST http://localhost:8080/api/v1/load-optimizer/optimize \
  -H "Content-Type: application/json" \
  -d @sample.json
```
