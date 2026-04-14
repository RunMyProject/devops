# 🏗️ Infrastruttura Cloud & DevOps — Dal Locale alla Produzione

> *"Scrivere codice è solo metà del lavoro. L'altra metà è farlo girare nel modo giusto, nel posto giusto, in modo ripetibile."*

---

## 🪆 La Matrioska DevOps

Ogni tecnologia vive **dentro** quella più grande.  
Non si escludono: si completano.

```
┌──────────────────────────────────────────────────┐
│           ☁️  CloudFormation / Terraform           │
│         (Crea server, reti, database AWS)         │
│                                                  │
│   ┌──────────────────────────────────────────┐   │
│   │         ⚙️  Kubernetes / K8s              │   │
│   │  (Orchestra i container in produzione)   │   │
│   │                                          │   │
│   │   ┌──────────────────────────────────┐   │   │
│   │   │      🐳  Docker Compose           │   │   │
│   │   │  (Container in locale / sviluppo) │   │   │
│   │   └──────────────────────────────────┘   │   │
│   └──────────────────────────────────────────┘   │
└──────────────────────────────────────────────────┘
```

---

## 🔍 Chi fa cosa — In una riga

| 🛠️ Strumento | 🎯 Cosa gestisce | 🏛️ Metafora edile |
| :--- | :--- | :--- |
| **☁️ CloudFormation / Terraform** | Server, reti, dischi, database nel cloud | Costruisce l'intero **Palazzo** |
| **⚙️ Kubernetes** | I container su server in produzione | Gestisce **Inquilini** e ascensori |
| **🐳 Docker Compose** | I container ma solo in locale | Il **plastico** del palazzo in ufficio |

---

## 🐳 Docker Compose — Il coordinatore locale

**Obiettivo:** far parlare tra loro i container **sul tuo PC**, durante lo sviluppo.

```yaml
# Esempio: alza Spring Boot + PostgreSQL insieme
services:
  app:
    image: my-spring-boot-app
  db:
    image: postgres:15
```

✅ Semplicissimo da usare  
✅ Perfetto per sviluppo e test locali  
⛔ Non sa cos'è AWS, non crea reti reali nel cloud  

---

## ⚙️ Kubernetes — L'orchestratore

**Obiettivo:** gestire **migliaia** di container su server diversi, in produzione.

```
Se un container muore   →  K8s lo riavvia automaticamente
Se il traffico aumenta  →  K8s crea 10 copie in parallelo
Se un nodo cade         →  K8s sposta tutto sugli altri
```

✅ Alta disponibilità e scalabilità automatica  
✅ Pensato per la produzione reale  
⛔ Deve girare **sopra** qualcosa — non crea i server su cui abita  

---

## ☁️ CloudFormation & Terraform — I padroni del Cloud

**Obiettivo:** creare le **fondamenta** dell'intera infrastruttura cloud.

```
CloudFormation / Terraform dicono ad AWS:
  → "Dammi un server con 8GB di RAM"
  → "Crea un database RDS con backup giornaliero"
  → "Apri il firewall sulla porta 8080"
  → "Crea il cluster dove installerò Kubernetes"
```

✅ Infrastructure as Code (IaC) — l'infrastruttura è versionata come il codice  
✅ Ripetibile, tracciabile, condivisibile con il team  
⛔ Non configura *dentro* i server — per quello c'è Ansible  

---

## 🔄 CloudFormation vs Terraform

| | ☁️ CloudFormation | 🌍 Terraform |
| :--- | :--- | :--- |
| **Vendor** | Proprietario AWS | Cloud Agnostic |
| **Compatibilità** | Solo AWS | AWS, Azure, GCP... |
| **Gestione stato** | Automatica (AWS) | File locale/remoto |
| **Standard mercato** | In ambienti AWS-only | ✅ Riferimento del settore |
| **Vendor lock-in** | Sì | No |

> 💡 **Terraform** è lo standard perché evita di legarsi a un solo fornitore.  
> Stessa sintassi, qualsiasi cloud.

---

## 🔧 Ansible — La configurazione granulare

C'è una distinzione importante che spesso viene sottovalutata:

```
PROVISIONING         →  Creare le risorse
CONFIGURATION        →  Configurare ciò che c'è dentro
```

| | Terraform / CloudFormation | Ansible |
| :--- | :--- | :--- |
| **Fa** | Crea il server | Entra nel server e lo configura |
| **Esempio** | "Dammi un'istanza EC2 vuota" | "Installa Nginx, imposta i permessi, riavvia il servizio" |
| **Analogia** | Costruisce la stanza | Arredala e la rende abitabile |

---

## 🎯 La Tripletta — Il flusso completo

```
  FASE 1 — Costruzione
  ┌─────────────────────────────────────────────┐
  │  Terraform / CloudFormation                 │
  │  → Crea server, reti, database              │
  └─────────────────────────────────────────────┘
                        ↓
  FASE 2 — Configurazione
  ┌─────────────────────────────────────────────┐
  │  Ansible                                    │
  │  → Installa dipendenze, imposta permessi    │
  └─────────────────────────────────────────────┘
                        ↓
  FASE 3 — Deploy applicativo
  ┌─────────────────────────────────────────────┐
  │  Docker / Kubernetes                        │
  │  → Porta i microservizi Spring Boot         │
  └─────────────────────────────────────────────┘
```

In tre parole: **costruisci → configura → deploya**.

---

## 💼 Perché le aziende cercano queste competenze

Le aziende non cercano solo chi sa scrivere codice.  
Cercano chi sa **portarlo in produzione** in modo affidabile e scalabile.

- Chi gestisce **ambienti multi-cloud** usa Terraform per non dipendere da un solo fornitore
- Chi ha **server esistenti** da aggiornare usa Ansible per la configurazione automatizzata
- Chi scala in **alta disponibilità** usa Kubernetes per orchestrare senza downtime

Queste competenze trasformano uno sviluppatore in un profilo **full-stack del ciclo di vita del software**.

---

## 🗣️ Come lo spiego in due righe

> *"Uso **CloudFormation** o **Terraform** per definire l'infrastruttura come codice — l'intera base AWS: server, reti, database.  
> Conosco **Terraform** per la sua flessibilità multi-cloud, che evita il vendor lock-in.  
> Una volta alzato il ferro, **Ansible** mi serve per la configurazione granulare dei nodi.  
> E infine, **Docker** e **Kubernetes** portano i microservizi Spring Boot dentro quell'infrastruttura."*

---

## ✅ In sintesi

```
Docker Compose   →  Sviluppo locale, veloce e semplice
Kubernetes       →  Produzione, scalabilità, resilienza
Terraform        →  Infrastruttura cloud, multi-provider, IaC
Ansible          →  Configurazione interna ai server, granulare
```

Ogni strumento ha il suo posto.  
Saperli combinare è la differenza tra **deployare** e **deployare bene**. 🚀

---

*Documento realizzato per illustrare competenze DevOps & Cloud Infrastructure*  
*Stack di riferimento: Spring Boot · Docker · Kubernetes · Terraform · Ansible · AWS*

