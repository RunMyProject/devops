# 🏗️ Cloud Infrastructure & DevOps — From Local to Production

> *"Writing code is only half the job. The other half is running it the right way, in the right place, in a repeatable fashion."*

---

## 🪆 The DevOps Matryoshka

Every technology lives **inside** the larger one.  
They don't replace each other: they complete each other.

```
┌──────────────────────────────────────────────────┐
│           ☁️  CloudFormation / Terraform           │
│         (Creates servers, networks, databases)    │
│                                                  │
│   ┌──────────────────────────────────────────┐   │
│   │         ⚙️  Kubernetes / K8s              │   │
│   │  (Orchestrates containers in production) │   │
│   │                                          │   │
│   │   ┌──────────────────────────────────┐   │   │
│   │   │      🐳  Docker Compose           │   │   │
│   │   │  (Containers for local / dev)     │   │   │
│   │   └──────────────────────────────────┘   │   │
│   └──────────────────────────────────────────┘   │
└──────────────────────────────────────────────────┘
```

---

## 🔍 Who does what — At a glance

| 🛠️ Tool | 🎯 What it manages | 🏛️ Construction analogy |
| :--- | :--- | :--- |
| **☁️ CloudFormation / Terraform** | Servers, networks, disks, cloud databases | Builds the entire **Building** |
| **⚙️ Kubernetes** | Containers across production servers | Manages **Tenants** and elevators |
| **🐳 Docker Compose** | Containers, but only for development | The office **scale model** of the building |

---

## 🐳 Docker Compose — The local coordinator

**Goal:** make containers talk to each other **on your machine**, during development.

```yaml
# Example: bring up Spring Boot + PostgreSQL together
services:
  app:
    image: my-spring-boot-app
  db:
    image: postgres:15
```

✅ Dead simple to use  
✅ Perfect for local development and testing  
⛔ Has no concept of AWS — it can't create real networks or disks in the cloud  

---

## ⚙️ Kubernetes — The orchestrator

**Goal:** manage **thousands** of containers across many different servers, in production.

```
If a container dies      →  K8s restarts it automatically
If traffic spikes        →  K8s spins up 10 parallel copies
If a node goes down      →  K8s shifts everything to the others
```

✅ High availability and automatic scaling  
✅ Built for real production environments  
⛔ Must run **on top of** something — it cannot create the servers it lives on  

---

## ☁️ CloudFormation & Terraform — The cloud architects

**Goal:** lay the **foundations** of the entire cloud infrastructure.

```
CloudFormation / Terraform tell AWS:
  → "Give me a server with 8GB of RAM"
  → "Create an RDS database with daily backups"
  → "Open the firewall on port 8080"
  → "Create the cluster where I'll install Kubernetes"
```

✅ Infrastructure as Code (IaC) — infrastructure versioned just like source code  
✅ Repeatable, traceable, shareable across the team  
⛔ Does not configure *inside* the servers — that's Ansible's job  

---

## 🔄 CloudFormation vs Terraform

| | ☁️ CloudFormation | 🌍 Terraform |
| :--- | :--- | :--- |
| **Vendor** | AWS proprietary | Cloud Agnostic |
| **Compatibility** | AWS only | AWS, Azure, GCP... |
| **State management** | Automatic (AWS) | Local / remote file |
| **Industry standard** | In AWS-only environments | ✅ The market reference |
| **Vendor lock-in** | Yes | No |

> 💡 **Terraform** is the industry standard because it avoids tying yourself to a single provider.  
> Same syntax, any cloud.

---

## 🔧 Ansible — Granular configuration

There is an important distinction that often gets overlooked:

```
PROVISIONING         →  Creating the resources
CONFIGURATION        →  Setting up what's inside them
```

| | Terraform / CloudFormation | Ansible |
| :--- | :--- | :--- |
| **Does** | Creates the server | Enters the server and configures it |
| **Example** | "Give me an empty EC2 instance" | "Install Nginx, set permissions, restart the service" |
| **Analogy** | Builds the room | Furnishes it and makes it livable |

---

## 🎯 The Trio — The full pipeline

```
  PHASE 1 — Provisioning
  ┌─────────────────────────────────────────────┐
  │  Terraform / CloudFormation                 │
  │  → Creates servers, networks, databases     │
  └─────────────────────────────────────────────┘
                        ↓
  PHASE 2 — Configuration
  ┌─────────────────────────────────────────────┐
  │  Ansible                                    │
  │  → Installs dependencies, sets permissions  │
  └─────────────────────────────────────────────┘
                        ↓
  PHASE 3 — Application deploy
  ┌─────────────────────────────────────────────┐
  │  Docker / Kubernetes                        │
  │  → Ships the Spring Boot microservices      │
  └─────────────────────────────────────────────┘
```

In three words: **provision → configure → deploy**.

---

## 💼 Why companies look for these skills

Companies are not just looking for people who can write code.  
They need people who can **ship it to production** reliably and at scale.

- Teams managing **multi-cloud environments** use Terraform to avoid dependency on a single provider
- Teams with **existing servers** to maintain use Ansible for automated configuration
- Teams scaling at **high availability** use Kubernetes to orchestrate without downtime

These skills turn a developer into a **full software lifecycle** profile.

---

## 🗣️ How I explain it in two lines

> *"I use **CloudFormation** or **Terraform** to define infrastructure as code — the full AWS foundation: servers, networks, databases.  
> I know **Terraform** for its multi-cloud flexibility, which avoids vendor lock-in.  
> Once the iron is up, **Ansible** handles granular node configuration.  
> And finally, **Docker** and **Kubernetes** bring the Spring Boot microservices into that infrastructure."*

---

## ✅ In a nutshell

```
Docker Compose   →  Local development, fast and simple
Kubernetes       →  Production, scalability, resilience
Terraform        →  Cloud infrastructure, multi-provider, IaC
Ansible          →  Internal server configuration, granular
```

Every tool has its place.  
Knowing how to combine them is the difference between **deploying** and **deploying well**. 🚀

---

*Written to demonstrate DevOps & Cloud Infrastructure knowledge*  
*Stack: Spring Boot · Docker · Kubernetes · Terraform · Ansible · AWS*
