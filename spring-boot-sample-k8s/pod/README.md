# Overview

Here the focus will be on how we can create a `pod` which uses a docker image, built using a `Spring Boot Application`, and access their APIs from outside the container inside which the pod will be running.

## Getting Started

### Create pod
```sh
kubectl apply -f pod.yaml
```
> **Expected output:** pod/spring-boot-sample-pod created

This will create a pod in the current context of your K8s cluster. You can run the following command to list all pods:
```sh
kubectl get pods

# to list detailed view
kubectl get pods -o wide
```
> Wait for the `STATUS` to be `Running` and `READY` to be `1/1`

Additional commands which will be helpful for debugging:
```sh
# view pod info
kubectl describe pod spring-boot-sample-pod

# view pod logs
kubectl logs spring-boot-sample-pod

# tail pod logs
kubectl logs -f spring-boot-sample-pod
```

### Test
The APIs would not be accessible from outside the container just yet, i.e., if you try calling the [endpoints](https://github.com/ImRohitSingh/all-things-cloud/tree/master/spring-boot-sample#test), they will choke. However, we can run the commands from inside the container. To go inside the container run the following command:
```sh
kubectl exec -it spring-boot-sample-pod -- bash
```
> For Windows Bash, use `winpty kubectl exec -it spring-boot-sample-pod -- bash`

Now run the curl commands!

In order to access the APIs from outside, we need to define an abstraction, which is nothing but another K8s REST object named `service`.

### Create Service
```sh
kubectl apply -f service.yaml
```
> **Expected output:** service/spring-boot-sample-service created

This creates a new `Service object` which targets TCP port 5151 on the pod with the `app.kubernetes.io/name: spring-boot-sample-app` label (which is our pod).

Additional commands which will be helpful for debugging:
```sh
# list services
kubectl get services

# list services with additional details
kubectl get services -o wide

# view service info
kubectl describe service spring-boot-sample-service
```

This also creates a corresponding `Endpoints object` (with same name as the service) automatically, to map it to the network address and port where it is running. To view details of it the following commands can be used:
```sh
# list endpoints
kubectl get endpoints

# view endpoint info
kubectl describe endpoints spring-boot-sample-service
```

Now you can access the APIs from your local machine!!

### Deletion
```sh
# delete service
kubectl delete service spring-boot-sample-service
[Expected output: service "spring-boot-sample-service" deleted]

# delete pod
kubectl delete pod spring-boot-sample-pod
[Expected output: pod "spring-boot-sample-pod" deleted]
```

