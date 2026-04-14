# 🏗️ DevOps Playground — CloudFormation · Ansible · Docker · Spring Boot

A hands-on local lab that simulates a full cloud deployment pipeline:  
from infrastructure provisioning to a running Spring Boot container — all scriptable, all reproducible.

> **Stack:** AWS (LocalStack) · CloudFormation · Ansible · Docker · Spring Boot (Java 17)

---

## 📚 Documentation

| Language | Link |
| :--- | :--- |
| 🇮🇹 Italiano | [Guida all'Infrastruttura Cloud](docs/infrastruttura-cloud.it.md) |
| 🇬🇧 English | [Cloud Infrastructure Guide](docs/devops-cloud-infrastructure.md) |

---

## ✅ Demo — It works

```bash
edoardo@master-node:~/devops$ ./cloudformation.sh
{
    "StackId": "arn:aws:cloudformation:us-east-1:000000000000:stack/mio-stack/25b52699-7cbe-4eab-81da-43fe231c07f7"
}

edoardo@master-node:~/devops$ ./cloudstatus.sh
"CREATE_COMPLETE"

edoardo@master-node:~/devops$ ./myplaybook.sh
PLAY [Configurazione iniziale del server di Edoardo] ***************************

TASK [Gathering Facts] *********************************************************
ok: [54.214.134.103]

TASK [Crea una directory per i log di Spring] **********************************
ok: [54.214.134.103]

TASK [Crea un file di benvenuto personalizzato] ********************************
ok: [54.214.134.103]

TASK [Assicurati che il container Spring sia attivo] ***************************
changed: [54.214.134.103]

PLAY RECAP *********************************************************************
54.214.134.103 : ok=4  changed=1  unreachable=0  failed=0  skipped=0  rescued=0  ignored=0

edoardo@master-node:~/devops$ curl http://localhost:8080/hello
Hello World
```

---

## 🗂️ Project Structure

```
devops/
├── demo/                         # Spring Boot application
│   ├── Dockerfile                # Builds the Spring Boot image (Java 17 / Alpine)
│   └── .mvn/                     # Maven wrapper config
│
├── app_logs/                     # Log directory created by Ansible on the server
│
├── template.yaml                 # CloudFormation template — provisions an EC2 t2.micro
│                                 # and runs the Spring container on startup via UserData
│
├── hosts.ini                     # Ansible inventory — defines the target server
│                                 # (IP + connection settings)
│
├── setup-server.yml              # Ansible Playbook — configures the server:
│                                 # creates log dir, drops a welcome file,
│                                 # ensures the Spring container is running
│
├── cloudformation.sh             # Creates the CloudFormation stack on LocalStack
├── cloudstatus.sh                # Checks the current stack status (e.g. CREATE_COMPLETE)
├── deletestackcloudformation.sh  # Tears down the CloudFormation stack
├── liststacks.sh                 # Lists all active stacks on LocalStack
│
├── myplaybook.sh                 # Runs the Ansible playbook against hosts.ini
├── ansiblestop.sh                # Stops and removes the running Spring container
│
└── infrastruttura-cloud.it.md    # Italian conceptual guide (see docs/)
```

---

## 🚀 Getting Started

### Prerequisites

- [Docker](https://docs.docker.com/get-docker/) installed and running
- [LocalStack](https://docs.localstack.cloud/getting-started/installation/) running locally (`localstack start`)
- [AWS CLI](https://aws.amazon.com/cli/) configured (any dummy credentials work with LocalStack)
- [Ansible](https://docs.ansible.com/ansible/latest/installation_guide/) installed

### 1 — Build the Spring Boot image

```bash
cd demo
./mvnw package -DskipTests
docker build -t spring-hello .
```

### 2 — Provision the infrastructure

```bash
./cloudformation.sh    # Create the stack
./cloudstatus.sh       # Verify: should return "CREATE_COMPLETE"
```

### 3 — Configure the server with Ansible

```bash
./myplaybook.sh
```

### 4 — Test the endpoint

```bash
curl http://localhost:8080/hello
# → Hello World
```

### Teardown

```bash
./ansiblestop.sh                  # Stop the Spring container
./deletestackcloudformation.sh    # Delete the CloudFormation stack
```

---

## 🔑 Key Concepts

| Layer | Tool | Role |
| :--- | :--- | :--- |
| Infrastructure | CloudFormation / Terraform | Provisions servers, networks, databases |
| Configuration | Ansible | Installs dependencies, sets up the environment |
| Runtime | Docker | Runs the application container |
| Application | Spring Boot | Serves the HTTP endpoint |

For a deeper dive into how these layers interact, see the [documentation](#-documentation) above.

---

## 📄 License

MIT — use it, break it, learn from it.
