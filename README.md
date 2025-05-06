# Ciber Segurança
Neste repositório armazena atividades da Matéria de CiberSegurança:

- Criptografia
- AC2 Aplicação WEB


# Questão 1
( Apresentada no código acima )

*Na prática para rodar aplicação:*

**Pré-requisitos:**
   - Java Development Kit (JDK) instalado.
   - Maven ou Gradle instalado (este projeto usa Gradle).

2. **Clonar o Repositório (se aplicável):**
   ```bash
   git clone https://github.com/MelPLens/Cyber.git



3. **Rodar**
   1. Execute: ./gradlew build
   2. Execute: ./gradlew bootRun

   A aplicação estará disponível em http://localhost:8080

# Questão 2
*Explique as principais diferenças entre criptografia simétrica e criptografia assimétrica. Discuta os cenários onde cada tipo de criptografia seria mais adequado, com exemplos práticos:*

A criptografia simétrica usa a mesma chave para criptografar e descriptografar, enquanto a assimétrica utiliza um par de chaves (pública e privada) para esses processos. usaria a Criptografia simétrica para comunicação rápida e segura entre sistemas confiáveis, como criptografia de arquivos locais e VPNs. Já a criptografia assimétrica usaria em redes públicas para garantir a segurança na troca de chaves e no envio de emails autenticados.

# Questão 3
*Liste e explique pelo menos três ataques comuns que podem afetar aplicações web. Para cada ataque, explique como ele pode ser mitigado com as melhores práticas de segurança.*

- XSS injeta código malicioso no navegador de outros usuários. 
Mitigação:filtro o que entra, codifico o que sai e controlo as fontes de conteúdo
- SQL Injection explora falhas em consultas ao banco de dados.
Mitigação: uso consultas seguras
- CSRF força ações indesejadas em usuários autenticados.
Mitigação: crio códigos a parte por sessão e verifico de onde vem a ação
  
