# Overview

This repository will illustrate on how we can deploy a basic `Spring Boot application` in a local `Kubernetes (a.k.a K8s)` cluster.

We will use `Docker` as the container runtime and for K8s deployment, we will refer to the *latest image* (**ref.** [rs9893/spring-boot-sample](https://hub.docker.com/repository/docker/rs9893/spring-boot-sample)) created as part of [../spring-boot-sample](https://github.com/ImRohitSingh/all-things-cloud/tree/master/spring-boot-sample).

## Requirements

1. Docker
1. K8s cluster

> **Note:** We are using single-node K8s cluster offered by `Docker Desktop`. You can use any K8s cluster, per your convenience.

## Getting Started

Instead of using a pre-configured context (or `default` namespace), we will create a dedicated namespace and use it for the deployments:

```sh
# create namespace
kubectl create namespace <namespace_name>,
e.g., kubectl create namespace spring-boot-sample-test

# switch to the namespace
kubectl config set-context --current --namespace=<namespace_name>
e.g., kubectl config set-context --current --namespace=spring-boot-sample-test
```

Additional commands:
```sh
# view cluster info
kubectl cluster-info

# list nodes
kubectl get nodes

# view current context
kubectl config current-context
```

Go to the respective directories to deploy different K8s objects based on the same Docker image.