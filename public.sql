--
-- PostgreSQL database dump
--

-- Dumped from database version 14.5
-- Dumped by pg_dump version 14.5

-- Started on 2022-10-17 23:43:17

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 212 (class 1259 OID 16410)
-- Name: alunos; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.alunos (
    codigo_aluno integer NOT NULL,
    aluno text NOT NULL,
    data_nascimento date,
    sexo character(1),
    telefone text,
    celular text,
    email text,
    observacao text,
    endereco text,
    numero text,
    complemento text,
    bairro text,
    cidade text,
    estado character(2),
    pais text,
    cep text,
    CONSTRAINT alunos_sexo CHECK ((sexo = ANY (ARRAY['M'::bpchar, 'F'::bpchar])))
);


ALTER TABLE public.alunos OWNER TO postgres;

--
-- TOC entry 211 (class 1259 OID 16409)
-- Name: alunos_codigo_aluno_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.alunos_codigo_aluno_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.alunos_codigo_aluno_seq OWNER TO postgres;

--
-- TOC entry 3393 (class 0 OID 0)
-- Dependencies: 211
-- Name: alunos_codigo_aluno_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.alunos_codigo_aluno_seq OWNED BY public.alunos.codigo_aluno;


--
-- TOC entry 220 (class 1259 OID 16506)
-- Name: assiduidade; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.assiduidade (
    codigo_matricula integer NOT NULL,
    data_entrada timestamp without time zone DEFAULT LOCALTIMESTAMP NOT NULL
);


ALTER TABLE public.assiduidade OWNER TO postgres;

--
-- TOC entry 209 (class 1259 OID 16395)
-- Name: cidades; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.cidades (
    cidade text NOT NULL,
    estado character(2) NOT NULL,
    pais text NOT NULL
);


ALTER TABLE public.cidades OWNER TO postgres;

--
-- TOC entry 219 (class 1259 OID 16496)
-- Name: faturas_matriculas; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.faturas_matriculas (
    codigo_matricula integer NOT NULL,
    data_vencimento date NOT NULL,
    valor numeric(9,2) NOT NULL,
    data_pagamento timestamp without time zone,
    data_cancelamento date
);


ALTER TABLE public.faturas_matriculas OWNER TO postgres;

--
-- TOC entry 214 (class 1259 OID 16432)
-- Name: graduacoes; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.graduacoes (
    modalidade text NOT NULL,
    graduacao text NOT NULL
);


ALTER TABLE public.graduacoes OWNER TO postgres;

--
-- TOC entry 217 (class 1259 OID 16457)
-- Name: matriculas; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.matriculas (
    codigo_matricula integer NOT NULL,
    codigo_aluno integer NOT NULL,
    data_matricula date NOT NULL,
    dia_vencimento integer NOT NULL,
    data_encerramento date
);


ALTER TABLE public.matriculas OWNER TO postgres;

--
-- TOC entry 216 (class 1259 OID 16456)
-- Name: matriculas_codigo_matricula_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.matriculas_codigo_matricula_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.matriculas_codigo_matricula_seq OWNER TO postgres;

--
-- TOC entry 3394 (class 0 OID 0)
-- Dependencies: 216
-- Name: matriculas_codigo_matricula_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.matriculas_codigo_matricula_seq OWNED BY public.matriculas.codigo_matricula;


--
-- TOC entry 218 (class 1259 OID 16468)
-- Name: matriculas_modalidades; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.matriculas_modalidades (
    codigo_matricula integer NOT NULL,
    modalidade text NOT NULL,
    graduacao text,
    plano text NOT NULL,
    data_inicio date DEFAULT CURRENT_DATE,
    data_fim date
);


ALTER TABLE public.matriculas_modalidades OWNER TO postgres;

--
-- TOC entry 213 (class 1259 OID 16425)
-- Name: modalidades; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.modalidades (
    modalidade text NOT NULL
);


ALTER TABLE public.modalidades OWNER TO postgres;

--
-- TOC entry 215 (class 1259 OID 16444)
-- Name: planos; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.planos (
    modalidade text NOT NULL,
    plano text NOT NULL,
    valor_mensal numeric(9,2) NOT NULL
);


ALTER TABLE public.planos OWNER TO postgres;

--
-- TOC entry 210 (class 1259 OID 16402)
-- Name: usuarios; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.usuarios (
    usuario text NOT NULL,
    senha text NOT NULL,
    perfil text NOT NULL
);


ALTER TABLE public.usuarios OWNER TO postgres;

--
-- TOC entry 3201 (class 2604 OID 16413)
-- Name: alunos codigo_aluno; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.alunos ALTER COLUMN codigo_aluno SET DEFAULT nextval('public.alunos_codigo_aluno_seq'::regclass);


--
-- TOC entry 3203 (class 2604 OID 16460)
-- Name: matriculas codigo_matricula; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.matriculas ALTER COLUMN codigo_matricula SET DEFAULT nextval('public.matriculas_codigo_matricula_seq'::regclass);


--
-- TOC entry 3379 (class 0 OID 16410)
-- Dependencies: 212
-- Data for Name: alunos; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.alunos (codigo_aluno, aluno, data_nascimento, sexo, telefone, celular, email, observacao, endereco, numero, complemento, bairro, cidade, estado, pais, cep) FROM stdin;
1	jhonata	2001-12-29	M	40028922	12345678	email@email.com	obsedrvacao	endereço	100	compremento	bairro	criciuma	SC	brasil	123456
2	editado	1322-02-01	M	(44)4444-4444	(48)44444-4444	email,	observação	complemento	10	complemento	bairro	criciuma	SC	brasil	54455-555
5	comunista	2001-12-29	M	(48)4002-8922	(48)40028-9222	teste@teste.com	observação	endereço	10	complemento	bairro	criciuma	SC	brasil	89789-789
\.


--
-- TOC entry 3387 (class 0 OID 16506)
-- Dependencies: 220
-- Data for Name: assiduidade; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.assiduidade (codigo_matricula, data_entrada) FROM stdin;
\.


--
-- TOC entry 3376 (class 0 OID 16395)
-- Dependencies: 209
-- Data for Name: cidades; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.cidades (cidade, estado, pais) FROM stdin;
criciuma	SC	brasil
IÇARA	SC	brasil
\.


--
-- TOC entry 3386 (class 0 OID 16496)
-- Dependencies: 219
-- Data for Name: faturas_matriculas; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.faturas_matriculas (codigo_matricula, data_vencimento, valor, data_pagamento, data_cancelamento) FROM stdin;
\.


--
-- TOC entry 3381 (class 0 OID 16432)
-- Dependencies: 214
-- Data for Name: graduacoes; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.graduacoes (modalidade, graduacao) FROM stdin;
modalidade editada	testre editada
\.


--
-- TOC entry 3384 (class 0 OID 16457)
-- Dependencies: 217
-- Data for Name: matriculas; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.matriculas (codigo_matricula, codigo_aluno, data_matricula, dia_vencimento, data_encerramento) FROM stdin;
1	1	2022-10-15	10	\N
2	2	2022-10-15	10	\N
4	1	2022-10-17	1	\N
\.


--
-- TOC entry 3385 (class 0 OID 16468)
-- Dependencies: 218
-- Data for Name: matriculas_modalidades; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.matriculas_modalidades (codigo_matricula, modalidade, graduacao, plano, data_inicio, data_fim) FROM stdin;
\.


--
-- TOC entry 3380 (class 0 OID 16425)
-- Dependencies: 213
-- Data for Name: modalidades; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.modalidades (modalidade) FROM stdin;
judo
modalidade editada
\.


--
-- TOC entry 3382 (class 0 OID 16444)
-- Dependencies: 215
-- Data for Name: planos; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.planos (modalidade, plano, valor_mensal) FROM stdin;
judo	mensal	10.00
judo	anual	100.00
judo	semanal	50.00
judo	faixa preta	800.00
\.


--
-- TOC entry 3377 (class 0 OID 16402)
-- Dependencies: 210
-- Data for Name: usuarios; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.usuarios (usuario, senha, perfil) FROM stdin;
administrador	senha	ADMINISTRADOR
cadastral	senha	CADASTRAL
financeiro	senha	FINANCEIRO
\.


--
-- TOC entry 3395 (class 0 OID 0)
-- Dependencies: 211
-- Name: alunos_codigo_aluno_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.alunos_codigo_aluno_seq', 6, true);


--
-- TOC entry 3396 (class 0 OID 0)
-- Dependencies: 216
-- Name: matriculas_codigo_matricula_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.matriculas_codigo_matricula_seq', 5, true);


--
-- TOC entry 3212 (class 2606 OID 16418)
-- Name: alunos alunos_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.alunos
    ADD CONSTRAINT alunos_pk PRIMARY KEY (codigo_aluno);


--
-- TOC entry 3226 (class 2606 OID 16511)
-- Name: assiduidade assiduidade_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.assiduidade
    ADD CONSTRAINT assiduidade_pk PRIMARY KEY (codigo_matricula, data_entrada);


--
-- TOC entry 3207 (class 2606 OID 16401)
-- Name: cidades cidades_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cidades
    ADD CONSTRAINT cidades_pk PRIMARY KEY (cidade, estado, pais);


--
-- TOC entry 3224 (class 2606 OID 16500)
-- Name: faturas_matriculas faturas_matriculas_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.faturas_matriculas
    ADD CONSTRAINT faturas_matriculas_pk PRIMARY KEY (codigo_matricula, data_vencimento);


--
-- TOC entry 3216 (class 2606 OID 16438)
-- Name: graduacoes graduacoes_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.graduacoes
    ADD CONSTRAINT graduacoes_pk PRIMARY KEY (modalidade, graduacao);


--
-- TOC entry 3222 (class 2606 OID 16475)
-- Name: matriculas_modalidades matriculas_modalidades_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.matriculas_modalidades
    ADD CONSTRAINT matriculas_modalidades_pk PRIMARY KEY (codigo_matricula, modalidade);


--
-- TOC entry 3220 (class 2606 OID 16462)
-- Name: matriculas matriculas_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.matriculas
    ADD CONSTRAINT matriculas_pk PRIMARY KEY (codigo_matricula);


--
-- TOC entry 3214 (class 2606 OID 16431)
-- Name: modalidades modalidades_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.modalidades
    ADD CONSTRAINT modalidades_pk PRIMARY KEY (modalidade);


--
-- TOC entry 3218 (class 2606 OID 16450)
-- Name: planos planos_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.planos
    ADD CONSTRAINT planos_pk PRIMARY KEY (modalidade, plano);


--
-- TOC entry 3209 (class 2606 OID 16408)
-- Name: usuarios usuarios_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuarios
    ADD CONSTRAINT usuarios_pk PRIMARY KEY (usuario);


--
-- TOC entry 3210 (class 1259 OID 16424)
-- Name: alunos_1; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX alunos_1 ON public.alunos USING btree (aluno);


--
-- TOC entry 3227 (class 2606 OID 16419)
-- Name: alunos alunos_enderecos_f2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.alunos
    ADD CONSTRAINT alunos_enderecos_f2 FOREIGN KEY (cidade, estado, pais) REFERENCES public.cidades(cidade, estado, pais) DEFERRABLE;


--
-- TOC entry 3236 (class 2606 OID 16512)
-- Name: assiduidade assiduidade_f1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.assiduidade
    ADD CONSTRAINT assiduidade_f1 FOREIGN KEY (codigo_matricula) REFERENCES public.matriculas(codigo_matricula) DEFERRABLE;


--
-- TOC entry 3235 (class 2606 OID 16501)
-- Name: faturas_matriculas faturas_matriculas_f1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.faturas_matriculas
    ADD CONSTRAINT faturas_matriculas_f1 FOREIGN KEY (codigo_matricula) REFERENCES public.matriculas(codigo_matricula) DEFERRABLE;


--
-- TOC entry 3228 (class 2606 OID 16439)
-- Name: graduacoes graduacoes_f1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.graduacoes
    ADD CONSTRAINT graduacoes_f1 FOREIGN KEY (modalidade) REFERENCES public.modalidades(modalidade) DEFERRABLE;


--
-- TOC entry 3230 (class 2606 OID 16463)
-- Name: matriculas matriculas_f1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.matriculas
    ADD CONSTRAINT matriculas_f1 FOREIGN KEY (codigo_aluno) REFERENCES public.alunos(codigo_aluno) DEFERRABLE;


--
-- TOC entry 3231 (class 2606 OID 16476)
-- Name: matriculas_modalidades matriculas_modalidades_f1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.matriculas_modalidades
    ADD CONSTRAINT matriculas_modalidades_f1 FOREIGN KEY (codigo_matricula) REFERENCES public.matriculas(codigo_matricula) DEFERRABLE;


--
-- TOC entry 3232 (class 2606 OID 16481)
-- Name: matriculas_modalidades matriculas_modalidades_f2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.matriculas_modalidades
    ADD CONSTRAINT matriculas_modalidades_f2 FOREIGN KEY (modalidade) REFERENCES public.modalidades(modalidade) DEFERRABLE;


--
-- TOC entry 3233 (class 2606 OID 16486)
-- Name: matriculas_modalidades matriculas_modalidades_f3; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.matriculas_modalidades
    ADD CONSTRAINT matriculas_modalidades_f3 FOREIGN KEY (modalidade, graduacao) REFERENCES public.graduacoes(modalidade, graduacao) DEFERRABLE;


--
-- TOC entry 3234 (class 2606 OID 16491)
-- Name: matriculas_modalidades matriculas_modalidades_f4; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.matriculas_modalidades
    ADD CONSTRAINT matriculas_modalidades_f4 FOREIGN KEY (modalidade, plano) REFERENCES public.planos(modalidade, plano) DEFERRABLE;


--
-- TOC entry 3229 (class 2606 OID 16451)
-- Name: planos planos_f1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.planos
    ADD CONSTRAINT planos_f1 FOREIGN KEY (modalidade) REFERENCES public.modalidades(modalidade) DEFERRABLE;


-- Completed on 2022-10-17 23:43:18

--
-- PostgreSQL database dump complete
--

