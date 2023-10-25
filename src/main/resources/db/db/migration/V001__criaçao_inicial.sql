
CREATE TABLE IF NOT EXISTS abrigos (
                                       abrigo_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
                                       abrigo_nome VARCHAR(45) NOT NULL,
    abrigo_contato VARCHAR(15) NOT NULL,
    abrigo_inauguracao DATE NOT NULL,
    abrigo_cep VARCHAR(9) NOT NULL,
    abrigo_rua VARCHAR(45) NOT NULL,
    abrigo_bairro VARCHAR(45) NOT NULL,
    abrigo_cidade VARCHAR(45) NOT NULL,
    abrigo_estado VARCHAR(2) NOT NULL,
    abrigo_nr_abrigos INT NOT NULL,
    abrigo_status VARCHAR(45) NOT NULL,
    abrigo_capacidade INT NOT NULL,
    abrigo_responsavel VARCHAR(45) NOT NULL);

CREATE TABLE IF NOT EXISTS pessoas (
                                       pessoa_id INT PRIMARY KEY AUTO_INCREMENT,
                                       pessoa_cpf VARCHAR(14) NULL,
    pessoa_nome VARCHAR(45) NOT NULL,
    pessoa_contato VARCHAR(15) NULL,
    pessoa_email VARCHAR(45) NULL,
    pessoa_genero VARCHAR(45) NOT NULL,
    data_nascimento DATE NOT NULL,
    pessoa_cep VARCHAR(9) NULL,
    pessoa_rua VARCHAR(45) NULL,
    pessoa_bairro VARCHAR(45) NULL,
    pessoa_cidade VARCHAR(45) NULL,
    pessoa_estado VARCHAR(2) NULL,
    pessoa_nr_residencia INT NULL,
    pessoa_usuario VARCHAR(45) NOT NULL,
    pessoa_senha VARCHAR(45) NOT NULL);

CREATE TABLE IF NOT EXISTS atendimentos (
                                            atendimento_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
                                            pessoa_id INT NOT NULL,
                                            abrigo_id INT NOT NULL,
                                            atendimento_data DATE NOT NULL,
                                            observacao VARCHAR(256) NULL,
    tomada_decisao VARCHAR(256) NULL,
    atendimento_responsavel VARCHAR(45) NOT NULL,
    CONSTRAINT fk_pes_atendimento
    FOREIGN KEY (pessoa_id)
    REFERENCES pessoas (pessoa_id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    CONSTRAINT fk_abrigo_atendimento
    FOREIGN KEY (abrigo_id)
    REFERENCES abrigos (abrigo_id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
    );

CREATE TABLE IF NOT EXISTS usuarios (
                                        usuario_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
                                        usuario_cpf VARCHAR(45) NOT NULL,
    usuario_email VARCHAR(45) NOT NULL,
    usuario_senha VARCHAR(45) NOT NULL
    );

CREATE TABLE IF NOT EXISTS designacao (
                                          designacao_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
                                          abrigo_id INT NOT NULL,
                                          pessoa_id INT NOT NULL,
                                          designacao_data DATE NOT NULL,
                                          designacao_responsavel VARCHAR(45)
    );





