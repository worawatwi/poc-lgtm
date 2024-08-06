# Grafana LGTM

Install Mimir

```
helm upgrade mimir --install grafana/mimir-distributed \
  --namespace mimir \
  --create-namespace \
  --values mimir.yaml
```

Install Tempo

```
helm upgrade tempo --install grafana/tempo-distributed \
  --namespace tempo \
  --create-namespace \
  --values tempo.yaml
```

Install Loki

```
helm upgrade loki --install grafana/loki \
  --namespace loki \
  --create-namespace \
  --values loki.yaml
```



```
helm upgrade grafana --install grafana/grafana \
  --namespace monitoring \
  --create-namespace \
  --values grafana.yaml
```


```
helm upgrade alloy --install grafana/alloy \
  --namespace monitoring \
  --create-namespace \
  --values alloy.yaml
```

```
helm upgrade cert-manager --install jetstack/cert-manager \
  --namespace cert-manager \
  --create-namespace \
  --values cert-manager.yaml
```

```
helm upgrade opentelemetry-operator --install open-telemetry/opentelemetry-operator \
  --namespace opentelemetry-system \
  --create-namespace \
  --values otel-operator.yaml \
  --version 0.52.4
```

```
kubectl apply -f https://github.com/kubernetes-sigs/gateway-api/releases/download/v1.1.0/standard-install.yaml
```

```
helm upgrade kong --install kong/ingress \
  --namespace gateway \
  --create-namespace \
  --values kong.yaml \
  --version 0.13.0
```