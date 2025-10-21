CREATE TABLE organizacao (
                             id_organizacao SERIAL PRIMARY KEY,
                             org_nome VARCHAR(150) NOT NULL,
                             org_cnpj VARCHAR(14) UNIQUE NOT NULL,
                             org_email VARCHAR(100) UNIQUE,
                             org_telefone V\ARCHAR(15),
                             org_ativo BOOLEAN DEFAULT TRUE
);

-- Papéis (funções do sistema)
CREATE TABLE papel (
                       id_papel SERIAL PRIMARY KEY,
                       pap_nome VARCHAR(50) UNIQUE NOT NULL, -- 'admin', 'analista', 'cliente'
                       pap_descricao TEXT
);

-- Permissões (ações do sistema)
CREATE TABLE permissao (
                           id_permissao SERIAL PRIMARY KEY,
                           per_nome VARCHAR(50) UNIQUE NOT NULL, -- 'abrir_chamado', 'atender_chamado', 'gerenciar_usuarios'
                           per_descricao TEXT
);

-- Relação N:N entre papéis e permissões
CREATE TABLE papel_permissao (
                                 id_papel INT NOT NULL REFERENCES papel(id_papel) ON DELETE CASCADE,
                                 id_permissao INT NOT NULL REFERENCES permissao(id_permissao) ON DELETE CASCADE,
                                 PRIMARY KEY (id_papel, id_permissao)
);

-- Usuários
CREATE TABLE usuario (
                         id_usuario SERIAL PRIMARY KEY,
                         usu_nome VARCHAR(100) NOT NULL,
                         usu_email VARCHAR(100) UNIQUE NOT NULL,
                         usu_senha VARCHAR(255) NOT NULL,
                         usu_ativo BOOLEAN DEFAULT TRUE,

                         id_papel INT NOT NULL REFERENCES papel(id_papel),
                         id_organizacao INT REFERENCES organizacao(id_organizacao) ON DELETE CASCADE
);

-- Telefones
CREATE TABLE telefone (
                          id_telefone SERIAL PRIMARY KEY,
                          id_usuario INT NOT NULL REFERENCES usuario(id_usuario) ON DELETE CASCADE,
                          tel_ddd VARCHAR(3) NOT NULL,
                          tel_numero VARCHAR(11) NOT NULL,
                          tel_tipo VARCHAR(20) DEFAULT 'CELULAR', -- CELULAR, RESIDENCIAL, COMERCIAL, etc.
                          tel_principal BOOLEAN DEFAULT FALSE,
                          tel_ativo BOOLEAN DEFAULT TRUE,
                          created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

                          CONSTRAINT uk_telefone_unico UNIQUE (tel_ddd, tel_numero),
                          CONSTRAINT chk_tipo_telefone CHECK (tel_tipo IN ('CELULAR', 'RESIDENCIAL', 'COMERCIAL', 'OUTRO'))
);

-- Índices para melhor performance
CREATE INDEX idx_telefone_usuario ON telefone(id_usuario);
CREATE INDEX idx_telefone_principal ON telefone(id_usuario, tel_principal) WHERE tel_principal = true;

-- Endereços (podem ser da empresa ou do usuário)
CREATE TABLE endereco (
                          id_endereco SERIAL PRIMARY KEY,
                          id_usuario INT REFERENCES usuario(id_usuario) ON DELETE CASCADE,
                          id_organizacao INT REFERENCES organizacao(id_organizacao) ON DELETE CASCADE,

                          end_logradouro VARCHAR(255) NOT NULL,
                          end_numero VARCHAR(10) NOT NULL,
                          end_complemento VARCHAR(100),
                          end_cep VARCHAR(8) NOT NULL,
                          end_uf CHAR(2) NOT NULL
);

-- Chamados
CREATE TABLE chamado (
                         id_chamado SERIAL PRIMARY KEY,
                         cha_titulo VARCHAR(150) NOT NULL,
                         cha_descricao TEXT NOT NULL,

                         id_organizacao INT NOT NULL REFERENCES organizacao(id_organizacao) ON DELETE CASCADE,
                         id_usuario_abertura INT NOT NULL REFERENCES usuario(id_usuario), -- quem abriu
                         id_usuario_atribuido INT REFERENCES usuario(id_usuario), -- quem atende (analista)

                         cha_status VARCHAR(20) NOT NULL DEFAULT 'aberto', -- aberto, em_andamento, fechado
                         cha_prioridade VARCHAR(20) NOT NULL DEFAULT 'media', -- baixa, media, alta

                         cha_criado_em TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                         cha_atualizado_em TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                         cha_finalizado_em TIMESTAMP
);

-- Interações do chamado
CREATE TABLE interacao_chamado (
                                   id_interacao SERIAL PRIMARY KEY,
                                   id_chamado INT NOT NULL REFERENCES chamado(id_chamado) ON DELETE CASCADE,
                                   id_usuario INT NOT NULL REFERENCES usuario(id_usuario), -- quem interagiu
                                   int_mensagem TEXT NOT NULL,
                                   int_url_anexo VARCHAR(255), -- opcional: link de anexo ou arquivo
                                   int_criado_em TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE parametro_configuracao (
                                        id_parametro SERIAL PRIMARY KEY,
                                        par_chave VARCHAR(100) UNIQUE NOT NULL,       -- ex.: 'SMTP_HOST', 'EMAIL_PORTA', 'PASTA_UPLOAD'
                                        par_valor VARCHAR(500) NOT NULL,              -- pode armazenar string, número, JSON
                                        par_categoria VARCHAR(50) NOT NULL,           -- ex.: 'email', 'sistema', 'arquivos'
                                        par_descricao TEXT,                           -- explica a finalidade
                                        par_ativo BOOLEAN DEFAULT TRUE,
                                        par_atualizado_em TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Empresas que atendem chamados (prestadoras de serviço)
CREATE TABLE empresa_atendimento (
                                     id_empresa_atendimento SERIAL PRIMARY KEY,
                                     emp_nome VARCHAR(150) NOT NULL,
                                     emp_cnpj VARCHAR(14) UNIQUE NOT NULL,
                                     emp_email VARCHAR(100) UNIQUE,
                                     emp_telefone VARCHAR(15)
);


-- 1. Criar o usuario com senha forte
CREATE USER admin_thelp WITH PASSWORD 'S3nh4Sup3rS3gur@!2025';

-- 2. Conceder todos os privilegios no banco de dados "chamados"
GRANT ALL PRIVILEGES ON DATABASE THELP TO admin_thelp;

-- 3. Conceder privilegios em todas as tabelas (execute isto apos conectar ao banco "chamados")
GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA public TO admin_thelp;
GRANT ALL PRIVILEGES ON ALL SEQUENCES IN SCHEMA public TO admin_thelp;
GRANT ALL PRIVILEGES ON ALL FUNCTIONS IN SCHEMA public TO admin_thelp;

-- 4. Opcional: Tornar o usuario superusuario (se necessario)
ALTER USER admin_thelp WITH SUPERUSER;