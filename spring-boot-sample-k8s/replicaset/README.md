# Overview

Here the focus will be on how we can create a `replicaset`.

## Getting Started

```sh
# create replicaset
kubectl apply -f replicaset.yaml
Expectet Output: replicaset.apps/spring-boot-sample-replicaset created

# view replicaset info
kubectl describe replicaset spring-boot-sample-replicaset

# edit replicaset
kubectl edit replicaset spring-boot-sample-replicaset

# expose endpoints
kubectl apply -f service.yaml
Expected output: service/spring-boot-sample-service created

# list all objects
kubectl get all

# delete replicaset
kubectl delete replicaset spring-boot-sample-replicaset
Expected Output: replicaset.apps "spring-boot-sample-replicaset" deleted
```

> **Note**: Editing a replicaset using `kubectl edit replicaset` command <u>would not</u> have any effect in the pods. We need to manually delete a pod, so that the `controller` can identify the updated *spec* and scale the pods accordingly. To mitigate this behaviour we will use `deployment` instead.