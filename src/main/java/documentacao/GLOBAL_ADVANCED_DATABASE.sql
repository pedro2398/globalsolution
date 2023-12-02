
DROP TABLE depende CASCADE CONSTRAINTS;
DROP TABLE Convenio CASCADE CONSTRAINTS;
DROP TABLE Evento_consumo CASCADE CONSTRAINTS;
DROP TABLE Mensagem CASCADE CONSTRAINTS;
DROP TABLE Evento_check_in CASCADE CONSTRAINTS;
DROP TABLE Hospital CASCADE CONSTRAINTS;
DROP TABLE Receita_completa CASCADE CONSTRAINTS;
DROP TABLE Receita_parcial CASCADE CONSTRAINTS;
DROP TABLE Medicamento CASCADE CONSTRAINTS;
DROP TABLE Cargo CASCADE CONSTRAINTS;
DROP TABLE Profissional CASCADE CONSTRAINTS;
DROP TABLE paciente CASCADE CONSTRAINTS;


CREATE TABLE Paciente (
    id_paciente NUMBER(15) PRIMARY KEY,
    nome VARCHAR2(30),
    cpf NUMBER(11),
    carteirinha NUMBER(25),
    telefone NUMBER(10),
    celular NUMBER(11),
    rua VARCHAR2(50),
    numero_residencia VARCHAR2(10),
    complemento VARCHAR2(30),
    cep NUMBER(8),
    bairro VARCHAR2(30),
    cidade VARCHAR2(30),
    estado VARCHAR2(2),
    fk_Convenio_id_convenio VARCHAR2(15)
);

CREATE TABLE Profissional (
    id_profissional NUMBER(15) PRIMARY KEY,
    nome VARCHAR2(30),
    registro_profissional VARCHAR2(20),
    email VARCHAR2(50),
    senha VARCHAR2(30),
    celular NUMBER(11),
    fk_Cargo_id_cargo NUMBER(20)
);

CREATE TABLE Cargo (
    id_cargo NUMBER(20) PRIMARY KEY,
    titulo VARCHAR2(15),
    descricao VARCHAR2(200)
);

CREATE TABLE Medicamento (
    id_medicamento NUMBER(10) PRIMARY KEY,
    nome VARCHAR2(15),
    via_administracao NUMBER(1)
);

CREATE TABLE Receita_parcial (
    id_parcial VARCHAR2(15) PRIMARY KEY,
    quantidade NUMBER(4,2),
    horario TIMESTAMP,
    frequencia NUMBER(2),
    data_inicio DATE,
    data_fim DATE,
    fk_Medicamento_id_medicamento NUMBER(10),
    fk_Receita_completa_id_completa VARCHAR2(15)
);

CREATE TABLE Receita_completa (
    id_completa VARCHAR2(15) PRIMARY KEY,
    fk_Paciente_id_paciente NUMBER(15),
    fk_Profissional_id_profissional NUMBER(15)
);

CREATE TABLE Hospital (
    id_hospital VARCHAR2(15) PRIMARY KEY,
    nome VARCHAR2(20),
    cep NUMBER(8),
    rua VARCHAR2(50),
    numero VARCHAR2(5),
    complemento VARCHAR2(30),
    bairro VARCHAR2(30),
    cidade VARCHAR2(30),
    estado VARCHAR2(2),
    telefone_1 NUMBER(10),
    telefone_2 NUMBER(10),
    telefone_3 NUMBER(10),
    email VARCHAR2(50),
    senha VARCHAR2(30)
);

CREATE TABLE Evento_check_in (
    evento_time TIMESTAMP,
    id_evento VARCHAR2(15) PRIMARY KEY,
    valor NUMBER(1),
    fk_Paciente_id_paciente NUMBER(15)
);

CREATE TABLE Convenio (
    id_convenio VARCHAR2(15) PRIMARY KEY,
    nome VARCHAR2(15),
    telefone NUMBER(10),
    email VARCHAR2(50),
    senha VARCHAR2(30)
);

CREATE TABLE Evento_consumo (
    id_evento VARCHAR2(15) PRIMARY KEY,
    evento_time TIMESTAMP,
    valor NUMBER(1),
    fk_Receita_parcial_id_parcial VARCHAR2(15)
);

CREATE TABLE Mensagem (
    id_mensagem VARCHAR2(15) PRIMARY KEY,
    texto VARCHAR2(300),
    fk_Profissional_id_profissional NUMBER(15),
    fk_Paciente_id_paciente NUMBER(15)
);

CREATE TABLE depende (
    fk_Convenio_id_convenio VARCHAR2(15),
    fk_Hospital_id_hospital VARCHAR2(15)
);

ALTER TABLE Paciente ADD CONSTRAINT FK_Paciente_2
    FOREIGN KEY (fk_Convenio_id_convenio)
    REFERENCES Convenio (id_convenio);

ALTER TABLE Profissional ADD CONSTRAINT FK_Profissional_2
    FOREIGN KEY (fk_Cargo_id_cargo)
    REFERENCES Cargo (id_cargo);

ALTER TABLE Receita_parcial ADD CONSTRAINT FK_Receita_parcial_2
    FOREIGN KEY (fk_Medicamento_id_medicamento)
    REFERENCES Medicamento (id_medicamento);

ALTER TABLE Receita_parcial ADD CONSTRAINT FK_Receita_parcial_3
    FOREIGN KEY (fk_Receita_completa_id_completa)
    REFERENCES Receita_completa (id_completa);

ALTER TABLE Receita_completa ADD CONSTRAINT FK_Receita_completa_2
    FOREIGN KEY (fk_Paciente_id_paciente)
    REFERENCES Paciente (id_paciente);

ALTER TABLE Receita_completa ADD CONSTRAINT FK_Receita_completa_3
    FOREIGN KEY (fk_Profissional_id_profissional)
    REFERENCES Profissional (id_profissional);

ALTER TABLE Evento_check_in ADD CONSTRAINT FK_Evento_check_in_2
    FOREIGN KEY (fk_Paciente_id_paciente)
    REFERENCES Paciente (id_paciente);


ALTER TABLE Evento_consumo ADD CONSTRAINT FK_Evento_consumo_3
    FOREIGN KEY (fk_Receita_parcial_id_parcial)
    REFERENCES Receita_parcial (id_parcial);

ALTER TABLE Mensagem ADD CONSTRAINT FK_Mensagem_2
    FOREIGN KEY (fk_Profissional_id_profissional)
    REFERENCES Profissional (id_profissional);

ALTER TABLE Mensagem ADD CONSTRAINT FK_Mensagem_3
    FOREIGN KEY (fk_Paciente_id_paciente)
    REFERENCES Paciente (id_paciente);

ALTER TABLE depende ADD CONSTRAINT FK_depende_1
    FOREIGN KEY (fk_Convenio_id_convenio)
    REFERENCES Convenio (id_convenio);

ALTER TABLE depende ADD CONSTRAINT FK_depende_2
    FOREIGN KEY (fk_Hospital_id_hospital)
    REFERENCES Hospital (id_hospital);
    
    
--------------------------------------------------------------------------------------------------------------------------------------------------------------
--------------------------------------------------------------------------------------------------------------------------------------------------------------
------------------------------- INSERTS ----------------------------------------------------------------------------------------------------------------------
--------------------------------------------------------------------------------------------------------------------------------------------------------------
--------------------------------------------------------------------------------------------------------------------------------------------------------------


-- Inserir cargos --

INSERT INTO Cargo VALUES (1, 'Médico', 'Profissional de saúde qualificado');
INSERT INTO Cargo VALUES (2, 'Enfermeiro', 'Profissional de enfermagem especializado');
INSERT INTO Cargo VALUES (3, 'Nutricionista', 'Especialista em nutrição e alimentação');
INSERT INTO Cargo VALUES (4, 'Fisioterapeuta', 'Profissional especializado em reabilitação física');
INSERT INTO Cargo VALUES (5, 'Psicólogo', 'Especialista em saúde mental e emocional');


-- Inserir Medicamento --
INSERT INTO Medicamento VALUES (1, 'Paracetamol', 1);


-- Inserir Convenio --
INSERT INTO Convenio VALUES ('conv001', 'Plano Saúde A', 1234567890, 'planoa@email.com', 'senhaA');

INSERT INTO Convenio VALUES ('conv002', 'Plano Saúde B', 9876543210, 'planob@email.com', 'senhaB');

INSERT INTO Convenio VALUES ('conv003', 'Plano Saúde C', 1112223334, 'planoc@email.com', 'senhaC');

INSERT INTO Convenio VALUES ('conv004', 'Plano Saúde D', 5554443332, 'planod@email.com', 'senhaD');

INSERT INTO Convenio VALUES ('conv005', 'Plano Saúde E', 9871236548, 'planoe@email.com', 'senhaE');


-- Inserir Profissional --
INSERT INTO Profissional VALUES (1, 'Doutor Silva', 'CRM12345', 'doutor@email.com', 'senha123', 9988776655, 1);

-- Inserir Hospital --
INSERT INTO Hospital VALUES ('HOSP001', 'Hospital Central', 87654321, 'Rua Central', '123', 'Bloco A', 'Centro', 'Cidade Central', 'CC', 1122334455, 9988776655, 8877665544, 'hospital@email.com', 'senha123');


-- Inserir Pacientes --
INSERT INTO Paciente VALUES (1, 'João Silva', '12345678901', '123', 1234567890, 98765432101, 'Rua A', '101', 'Apto 1', 12345678, 'Centro', 'Cidade1', 'SP', 'conv001');

INSERT INTO Paciente VALUES (2, 'Maria Oliveira', '98765432109', '789', 9876543210, 98765432102, 'Rua B', '202', 'Casa 2', 87654321, 'Bairro2', 'Cidade2', 'RJ', 'conv002');

INSERT INTO Paciente VALUES (3, 'Carlos Santos', '11122233344', '456', 1112223334, 98765432103, 'Rua C', '303', 'Sala 3', 56789012, 'Bairro3', 'Cidade3', 'MG', 'conv003');

INSERT INTO Paciente VALUES (4, 'Ana Pereira', '55544433322', '789', 5554443332, 98765432104, 'Rua D', '404', 'Apto 4', 11223344, 'Bairro4', 'Cidade4', 'SP', 'conv004');

INSERT INTO Paciente VALUES (5, 'Rodrigo Lima', '98712365487', '012', 9871236548, 98765432105, 'Rua E', '505', 'Casa 5', 99887766, 'Bairro5', 'Cidade5', 'RJ', 'conv005');



-- Inserir Receita_completa --
INSERT INTO Receita_completa VALUES ('1', '1', 1);


-- Inserir Receita_parcial --
INSERT INTO Receita_parcial VALUES ('1', 2.5, SYSTIMESTAMP, 3, TO_DATE('2023-11-30', 'YYYY-MM-DD'), TO_DATE('2023-12-15', 'YYYY-MM-DD'), 1, 1);


-- Inserir Evento_check_in --
INSERT INTO Evento_check_in VALUES (TO_TIMESTAMP('2023-11-30 10:45:00', 'YYYY-MM-DD HH24:MI:SS'), 'EVT003', 1, 1);
INSERT INTO Evento_check_in VALUES (TO_TIMESTAMP('2023-12-10 10:45:00', 'YYYY-MM-DD HH24:MI:SS'), 'EVT004', 0, 2);


-- Inserir Evento_consumo --
INSERT INTO Evento_consumo VALUES ('EVT002', TO_TIMESTAMP('2023-11-30 14:30:00', 'YYYY-MM-DD HH24:MI:SS'), 2, '1');

-- Inserir Mensagem --
INSERT INTO Mensagem VALUES ('MSG001', 'Olá, como você está?', 1, 1);

-- Inserir depende --
INSERT INTO depende VALUES ('conv001', 'HOSP001');

--------------------------------------------------------------------------------------------------------------------------------------------------------------
--------------------------------------------------------------------------------------------------------------------------------------------------------------
------------------------------- BLOCOS PARA INSERIR DADOS ----------------------------------------------------------------------------------------------------
--------------------------------------------------------------------------------------------------------------------------------------------------------------
--------------------------------------------------------------------------------------------------------------------------------------------------------------


SET SERVEROUTPUT ON
-- Bloco para inserir dados na tabela Paciente --


DECLARE
    v_id_paciente NUMBER(15);
    v_nome VARCHAR2(30);
    v_cpf NUMBER(11);
    v_carteirinha NUMBER(25);
    v_telefone NUMBER(10);
    v_celular NUMBER(11);
    v_rua VARCHAR2(50);
    v_numero_residencia VARCHAR2(10);
    v_complemento VARCHAR2(30);
    v_cep NUMBER(8);
    v_bairro VARCHAR2(30);
    v_cidade VARCHAR2(30);
    v_estado VARCHAR2(2);
    v_fk_Convenio_id_convenio VARCHAR2(15);
    
    DUP_VAL_ON_INDEX EXCEPTION;
    PRAGMA EXCEPTION_INIT(DUP_VAL_ON_INDEX, -1);

BEGIN
    
    v_id_paciente := &id_paciente;
    v_nome := '&nome';
    v_cpf := &cpf;
    v_carteirinha := &carteirinha;
    v_telefone := &telefone;
    v_celular := &celular;
    v_rua := '&rua';
    v_numero_residencia := '&numero_residencia';
    v_complemento := '&complemento';
    v_cep := &cep;
    v_bairro := '&bairro';
    v_cidade := '&cidade';
    v_estado := '&estado';
    v_fk_Convenio_id_convenio := '&convenio';

    
    INSERT INTO Paciente (
        id_paciente, nome, cpf, carteirinha, telefone, celular, rua, numero_residencia,
        complemento, cep, bairro, cidade, estado, fk_Convenio_id_convenio
    ) VALUES (
        v_id_paciente, v_nome, v_cpf, v_carteirinha, v_telefone, v_celular, v_rua,
        v_numero_residencia, v_complemento, v_cep, v_bairro, v_cidade, v_estado, v_fk_Convenio_id_convenio
    );

    
    COMMIT;
EXCEPTION
    WHEN DUP_VAL_ON_INDEX THEN
        
        DBMS_OUTPUT.PUT_LINE('Erro: Inserção duplicada. Verifique os dados informados.');
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Erro: ' || SQLERRM);
END;
/
select * from paciente;
-- Bloco para inserir dados na tabela Profissional --

DECLARE
    v_id_profissional NUMBER(15);
    v_nome_profissional VARCHAR2(30);
    v_registro_profissional VARCHAR2(20);
    v_email_profissional VARCHAR2(50);
    v_senha_profissional VARCHAR2(30);
    v_celular_profissional NUMBER(11);
    v_fk_cargo_id_cargo NUMBER(20);

BEGIN
    v_id_profissional := &id_profissional;
    v_nome_profissional := '&nome_profissional';
    v_registro_profissional := '&registro_profissional';
    v_email_profissional := '&email_profissional';
    v_senha_profissional := '&senha_profissional';
    v_celular_profissional := &celular_profissional;
    v_fk_cargo_id_cargo := '&Codigo_do_cargo';

    
    INSERT INTO Profissional (
        id_profissional, nome, registro_profissional, email, senha, celular, fk_Cargo_id_cargo
    ) VALUES (
        v_id_profissional, v_nome_profissional, v_registro_profissional, v_email_profissional,
        v_senha_profissional, v_celular_profissional, v_fk_cargo_id_cargo
    );
    COMMIT;
EXCEPTION
    WHEN DUP_VAL_ON_INDEX THEN
        DBMS_OUTPUT.PUT_LINE('Erro: Inserção duplicada. Verifique os dados informados.');
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Erro: ' || SQLERRM);
END;
/
select * from profissional;

-- Bloco para inserir dados na tabela Hospital

DECLARE
    v_id_hospital VARCHAR2(15);
    v_nome_hospital VARCHAR2(20);
    v_cep_hospital NUMBER(8);
    v_rua_hospital VARCHAR2(50);
    v_numero_hospital VARCHAR2(5);
    v_complemento_hospital VARCHAR2(30);
    v_bairro_hospital VARCHAR2(30);
    v_cidade_hospital VARCHAR2(30);
    v_estado_hospital VARCHAR2(2);
    v_telefone1_hospital NUMBER(10);
    v_telefone2_hospital NUMBER(10);
    v_telefone3_hospital NUMBER(10);
    v_email_hospital VARCHAR2(50);
    v_senha_hospital VARCHAR2(30);

BEGIN
    v_id_hospital := '&id_hospital';
    v_nome_hospital := '&nome_hospital';
    v_cep_hospital := &cep_hospital;
    v_rua_hospital := '&rua_hospital';
    v_numero_hospital := '&numero_hospital';
    v_complemento_hospital := '&complemento_hospital';
    v_bairro_hospital := '&bairro_hospital';
    v_cidade_hospital := '&cidade_hospital';
    v_estado_hospital := '&estado_hospital';
    v_telefone1_hospital := &telefone1_hospital;
    v_telefone2_hospital := &telefone2_hospital;
    v_telefone3_hospital := &telefone3_hospital;
    v_email_hospital := '&email_hospital';
    v_senha_hospital := '&senha_hospital';

    INSERT INTO Hospital (
        id_hospital, nome, cep, rua, numero, complemento, bairro, cidade, estado,
        telefone_1, telefone_2, telefone_3, email, senha
    ) VALUES (
        v_id_hospital, v_nome_hospital, v_cep_hospital, v_rua_hospital, v_numero_hospital,
        v_complemento_hospital, v_bairro_hospital, v_cidade_hospital, v_estado_hospital,
        v_telefone1_hospital, v_telefone2_hospital, v_telefone3_hospital, v_email_hospital,
        v_senha_hospital
    );

    COMMIT;
EXCEPTION
    WHEN DUP_VAL_ON_INDEX THEN
        DBMS_OUTPUT.PUT_LINE('Erro: Inserção duplicada. Verifique os dados informados.');
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Erro: ' || SQLERRM);
END;
/

select * from hospital;

-- Bloco para inserir dados na tabela Cargo

DECLARE
    v_id_cargo NUMBER(15);
    v_titulo_cargo VARCHAR2(50);
    v_desc_cargo VARCHAR2(200);

BEGIN
   
    v_id_cargo := &id_cargo;
    v_titulo_cargo := '&titulo_cargo';
    v_desc_cargo := '&descricao_cargo';

    
    INSERT INTO Cargo (
        id_cargo, titulo, descricao
    ) VALUES (
        v_id_cargo, v_titulo_cargo, v_desc_cargo 
    );

    COMMIT;
EXCEPTION
    WHEN DUP_VAL_ON_INDEX THEN
        DBMS_OUTPUT.PUT_LINE('Erro: Inserção duplicada. Verifique os dados informados.');
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Erro: ' || SQLERRM);
END;
/
select * from cargo;


-- Bloco para inserir dados na tabela Medicamento

DECLARE
    v_id_medicamento NUMBER(10);
    v_nome_medicamento VARCHAR2(15);
    v_via_administracao NUMBER(1);

BEGIN
    -- Entrada de dados via teclado
    v_id_medicamento := &id_medicamento;
    v_nome_medicamento := '&nome_medicamento';
    v_via_administracao := &via_administracao;

    -- Inserção de dados na tabela Medicamento
    INSERT INTO Medicamento (
        id_medicamento, nome, via_administracao
    ) VALUES (
        v_id_medicamento, v_nome_medicamento, v_via_administracao
    );

    -- Comita a transação
    COMMIT;
EXCEPTION
    WHEN DUP_VAL_ON_INDEX THEN
        -- Exceção para violação de chave única (duplicidade)
        DBMS_OUTPUT.PUT_LINE('Erro: Inserção duplicada. Verifique os dados informados.');
    WHEN OTHERS THEN
        -- Exceção geral para outros erros
        DBMS_OUTPUT.PUT_LINE('Erro: ' || SQLERRM);
END;
/
select * from medicamento;

-- Bloco para inserir dados na tabela Receita_parcial

DECLARE
    v_id_parcial VARCHAR2(15);
    v_quantidade NUMBER(4, 2);
    v_horario TIMESTAMP;
    v_frequencia NUMBER(2);
    v_data_inicio DATE;
    v_data_fim DATE;
    v_fk_medicamento_id_medicamento NUMBER(10);
    v_fk_Receita_completa_id VARCHAR2(15);

BEGIN
    v_id_parcial := '&id_receita_parcial';
    v_quantidade := &quantidade;
    v_horario := TO_TIMESTAMP('&horario', 'HH24:MI:SS') ;
    v_frequencia := &frequencia;
    v_data_inicio := TO_DATE('&data_inicio', 'YYYY-MM-DD');
    v_data_fim := TO_DATE('&data_fim', 'YYYY-MM-DD');
    v_fk_medicamento_id_medicamento := '&id_medicamento';
    v_fk_Receita_completa_id := '&id_receita_completa';
    INSERT INTO Receita_parcial (
        id_parcial, quantidade, horario, frequencia, data_inicio, data_fim, fk_medicamento_id_medicamento, fk_Receita_completa_id_completa
    ) VALUES (
        v_id_parcial, v_quantidade, v_horario, v_frequencia, v_data_inicio, v_data_fim, v_fk_medicamento_id_medicamento, v_fk_Receita_completa_id
    );

    COMMIT;
EXCEPTION
    WHEN DUP_VAL_ON_INDEX THEN
        DBMS_OUTPUT.PUT_LINE('Erro: Inserção duplicada. Verifique os dados informados.');
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Erro: ' || SQLERRM);
END;
/
select * from receita_parcial;

-- Bloco para inserir dados na tabela Receita_completa

DECLARE
    v_id_completa VARCHAR2(15);
    v_fk_paciente_id_paciente NUMBER(15);
    v_fk_profissional_id_profissional NUMBER(15);

BEGIN
    v_id_completa := '&id_completa';
    v_fk_paciente_id_paciente := &fk_paciente_id_paciente;
    v_fk_profissional_id_profissional := &fk_profissional_id_profissional;

    INSERT INTO Receita_completa (
        id_completa, fk_paciente_id_paciente, fk_profissional_id_profissional
    ) VALUES (
        v_id_completa, v_fk_paciente_id_paciente, v_fk_profissional_id_profissional
    );

    COMMIT;
EXCEPTION
    WHEN DUP_VAL_ON_INDEX THEN
        DBMS_OUTPUT.PUT_LINE('Erro: Inserção duplicada. Verifique os dados informados.');
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Erro: ' || SQLERRM);
END;
/
select * from receita_completa;

-- Bloco para inserir dados na tabela Convenio

DECLARE
    v_id_convenio VARCHAR2(15);
    v_nome_convenio VARCHAR2(15);
    v_telefone_convenio NUMBER(10);
    v_email_convenio VARCHAR2(50);
    v_senha_convenio VARCHAR2(30);
    

BEGIN
    v_id_convenio := '&id_convenio';
    v_nome_convenio := '&nome_convenio';
    v_telefone_convenio := &telefone_convenio;
    v_email_convenio := '&email_convenio';
    v_senha_convenio := '&senha_convenio';
    

    INSERT INTO Convenio (
        id_convenio, nome, telefone, email, senha
    ) VALUES (
        v_id_convenio, v_nome_convenio, v_telefone_convenio, v_email_convenio, v_senha_convenio
    );

    COMMIT;
EXCEPTION
    WHEN DUP_VAL_ON_INDEX THEN
        DBMS_OUTPUT.PUT_LINE('Erro: Inserção duplicada. Verifique os dados informados.');
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Erro: ' || SQLERRM);
END;
/
select * from convenio;
-- Bloco para inserir dados na tabela Evento_consumo

DECLARE
    v_momento_evento TIMESTAMP;
    v_id_evento VARCHAR2(15);
    v_valor_evento NUMBER(1);
    v_fk_Receita_parcial_id_parcial VARCHAR2(15);
    
BEGIN
    v_momento_evento := SYSTIMESTAMP;
    v_id_evento := &id_evento;
    v_valor_evento := '&evento_ocorreu?';
    v_fk_Receita_parcial_id_parcial  := '&id_receita_att';

    INSERT INTO Evento_consumo (
        evento_time, id_evento, valor, fk_Receita_parcial_id_parcial
    ) VALUES (
        v_momento_evento, v_id_evento, v_valor_evento, v_fk_Receita_parcial_id_parcial
    );

    COMMIT;
EXCEPTION
    WHEN DUP_VAL_ON_INDEX THEN
        DBMS_OUTPUT.PUT_LINE('Erro: Inserção duplicada. Verifique os dados informados.');
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Erro: ' || SQLERRM);
END;
/
select * from evento_consumo;

-- Bloco para inserir dados na tabela Evento_check_in

DECLARE
    v_evento_time TIMESTAMP;
    v_id_evento VARCHAR2(15);
    v_valor NUMBER(1);
    v_fk_paciente_id_paciente NUMBER(15);
BEGIN
    v_evento_time := SYSTIMESTAMP;
    v_id_evento := '&id_evento';
    v_valor := &valor;
    v_fk_paciente_id_paciente := &fk_paciente_id_paciente;

    INSERT INTO Evento_check_in (
        evento_time, id_evento, valor, fk_Paciente_id_paciente
    ) VALUES (
        v_evento_time, v_id_evento, v_valor, v_fk_paciente_id_paciente
    );

    COMMIT;
EXCEPTION
    WHEN DUP_VAL_ON_INDEX THEN
        DBMS_OUTPUT.PUT_LINE('Erro: Inserção duplicada. Verifique os dados informados.');
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Erro: ' || SQLERRM);
END;
/
select * from evento_check_in;


-- Bloco para inserir dados na tabela Mensagem


DECLARE
    v_id_mensagem VARCHAR2(15);
    v_texto VARCHAR2(300);
    v_fk_Profissional_id_profissional NUMBER(15);
    v_fk_Paciente_id_paciente NUMBER(15);
BEGIN
    v_id_mensagem := '&id_mensagem';
    v_texto := '&texto_da_mensagem';
    v_fk_Profissional_id_profissional := '&id_profissional';
    v_fk_Paciente_id_paciente := '&id_paciente';

    INSERT INTO Mensagem (
        id_mensagem, texto, fk_Profissional_id_profissional, fk_Paciente_id_paciente
    ) VALUES (
        v_id_mensagem, v_texto, v_fk_Profissional_id_profissional, v_fk_Paciente_id_paciente
    );

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Mensagem inserida com sucesso.');
EXCEPTION
    WHEN DUP_VAL_ON_INDEX THEN
        DBMS_OUTPUT.PUT_LINE('Erro: Inserção duplicada. Verifique os dados informados.');
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Erro: ' || SQLERRM);
END;
/
select * from mensagem;

-- Bloco para inserir dados na tabela Depende

DECLARE
    v_fk_Convenio_id_convenio VARCHAR2(15);
    v_fk_Hospital_id_hospital VARCHAR2(15);
BEGIN
    v_fk_Convenio_id_convenio := '&convenio_id';
    v_fk_Hospital_id_hospital := '&hospital_id';

    INSERT INTO depende (
        fk_Convenio_id_convenio, fk_Hospital_id_hospital
    ) VALUES (
        v_fk_Convenio_id_convenio, v_fk_Hospital_id_hospital
    );

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Relação de dependência inserida com sucesso.');
EXCEPTION
    WHEN DUP_VAL_ON_INDEX THEN
        DBMS_OUTPUT.PUT_LINE('Erro: Inserção duplicada. Verifique os dados informados.');
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Erro: ' || SQLERRM);
END;
/
select * from depende;


--------------------------------------------------------------------------------------------------------------------------------------------------------------
--------------------------------------------------------------------------------------------------------------------------------------------------------------
------------------------------- CONSULTAS COM CURSORES    ---------------------------------------------------------------------------------------------------
--------------------------------------------------------------------------------------------------------------------------------------------------------------
--------------------------------------------------------------------------------------------------------------------------------------------------------------

-- Consulta 1 --

DECLARE
    CURSOR cur_receitas IS
        SELECT
            rp.id_parcial,
            rp.quantidade,
            rp.horario,
            rp.frequencia,
            rp.data_inicio,
            rp.data_fim,
            m.nome AS medicamento_nome,
            m.via_administracao,
            rc.id_completa,
            p.nome AS paciente_nome
        FROM
            Receita_parcial rp
        JOIN
            Medicamento m ON rp.fk_Medicamento_id_medicamento = m.id_medicamento
        JOIN
            Receita_completa rc ON rp.fk_Receita_completa_id_completa = rc.id_completa
        JOIN
            Paciente p ON rc.fk_Paciente_id_paciente = p.id_paciente;

    v_id_parcial VARCHAR2(15);
    v_quantidade NUMBER(4, 2);
    v_horario TIMESTAMP;
    v_frequencia NUMBER(2);
    v_data_inicio DATE;
    v_data_fim DATE;
    v_medicamento_nome VARCHAR2(15);
    v_via_administracao NUMBER(1);
    v_id_completa VARCHAR2(15);
    v_paciente_nome VARCHAR2(30);

BEGIN
    OPEN cur_receitas;
    LOOP
        FETCH cur_receitas INTO
            v_id_parcial,
            v_quantidade,
            v_horario,
            v_frequencia,
            v_data_inicio,
            v_data_fim,
            v_medicamento_nome,
            v_via_administracao,
            v_id_completa,
            v_paciente_nome;

        EXIT WHEN cur_receitas%NOTFOUND;

        DBMS_OUTPUT.PUT_LINE('ID Parcial: ' || v_id_parcial);
        DBMS_OUTPUT.PUT_LINE('Quantidade: ' || v_quantidade);
        DBMS_OUTPUT.PUT_LINE('Horário: ' || v_horario);
        DBMS_OUTPUT.PUT_LINE('Frequência: ' || v_frequencia);
        DBMS_OUTPUT.PUT_LINE('Data de Início: ' || v_data_inicio);
        DBMS_OUTPUT.PUT_LINE('Data de Fim: ' || v_data_fim);
        DBMS_OUTPUT.PUT_LINE('Medicamento: ' || v_medicamento_nome);
        DBMS_OUTPUT.PUT_LINE('Via de Administração: ' || v_via_administracao);
        DBMS_OUTPUT.PUT_LINE('ID Completa: ' || v_id_completa);
        DBMS_OUTPUT.PUT_LINE('Paciente: ' || v_paciente_nome);
        DBMS_OUTPUT.PUT_LINE('----------------------------------');

    END LOOP;

    CLOSE cur_receitas;
END;
/

DECLARE
    v_id_paciente Paciente.id_paciente%TYPE;
    v_nome_paciente Paciente.nome%TYPE;
    v_quantidade_total NUMBER;

    CURSOR c_pacientes IS
        SELECT
            p.id_paciente,
            p.nome AS paciente_nome
        FROM
            Paciente p;

    CURSOR c_receitas (p_id_paciente Paciente.id_paciente%TYPE) IS
        SELECT
            SUM(rp.quantidade) AS quantidade_total
        FROM
            Receita_completa rc
        JOIN
            Receita_parcial rp ON rc.id_completa = rp.fk_Receita_completa_id_completa
        WHERE
            rc.fk_Paciente_id_paciente = p_id_paciente;

BEGIN
    FOR paciente_rec IN c_pacientes LOOP
        v_id_paciente := paciente_rec.id_paciente;
        v_nome_paciente := paciente_rec.paciente_nome;

        FOR receita_rec IN c_receitas(v_id_paciente) LOOP
            v_quantidade_total := receita_rec.quantidade_total;

            DBMS_OUTPUT.PUT_LINE('Paciente: ' || v_nome_paciente || ', Quantidade Total: ' || v_quantidade_total);
        END LOOP;
    END LOOP;
END;
/
