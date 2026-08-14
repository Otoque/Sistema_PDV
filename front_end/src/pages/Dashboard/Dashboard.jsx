    import React, { useState, useEffect } from "react";
    import axios from "axios";
    import { useNavigate } from "react-router-dom";
    import './Dashboard.css';

    function Dashboard() {
        const [cpfCliente, setCpfCliente] = useState('');
        const [dadosCliente, setDadosCliente] = useState(null);
        const [carregando, setCarregando] = useState(false);
        const [buscaItem, setBuscaItem] = useState('');
        const [nomeFuncionario, setNomeFuncionario] = useState('');
        
        const navigate = useNavigate();

        useEffect(() => {
            const funcionario = localStorage.getItem('nomeFuncionario');
            if (funcionario) setNomeFuncionario(funcionario);
        }, []);

        // Função para aplicar máscara em qualquer CPF (string digitada ou vinda do banco)
        const mascararCPF = (valor) => {
            if (!valor) return '';
            return valor
                .replace(/\D/g, '')                  
                .slice(0, 11)                           
                .replace(/(\d{3})(\d)/, '$1.$2')       
                .replace(/(\d{3})(\d)/, '$1.$2')       
                .replace(/(\d{3})(\d{1,2})$/, '$1-$2');
        };

        const buscarClientePorCpf = async (e) => {
            if (e) e.preventDefault();
            const cpfApenasNumeros = cpfCliente.replace(/\D/g, '');
            if (!cpfApenasNumeros) return alert("Por favor, digite o CPF do cliente!");
            setCpfCliente('');
            setCarregando(true);
            setDadosCliente(null);

            try {
                const response = await axios.get(`http://localhost:8080/client/${cpfApenasNumeros}`);
                
                // Log para conferir no console F12
                console.log("Dados do Cliente recebidos:", response.data);

                if (response.data && (response.data.name || response.data.nome)) {
                    setDadosCliente(response.data);
                } else {
                    alert('Cliente não encontrado com o CPF informado!');
                }
            } catch (error) {
                console.error("Erro na busca:", error);
                if (error.response && error.response.status === 404) {
                    alert('Cliente não encontrado com o CPF informado!');
                } else {
                    alert('Erro ao buscar cliente. Verifique se a API está rodando.');
                }
            } finally {
                setCarregando(false);
            }
        };

        return (
            <div className="dashboard-container">
                <header className="dashboard-header">
                    <div className="header-brand">
                        <h2>Farma Aura</h2>
                    </div>

                    <div className="header-search">
                        <input 
                            type="text" 
                            placeholder="Buscar item/produto..." 
                            value={buscaItem}
                            onChange={(e) => setBuscaItem(e.target.value)}
                            className="search-input"
                        />
                    </div>

                    <div className="header-user-area">
                        <span className="user-name">
                            {nomeFuncionario || 'Funcionário'}
                        </span>
                        <button className="cart-btn">
                            🛒 Carrinho
                        </button>
                    </div>
                </header>

                <div className="dashboard-body">
                    <aside className="client-panel">
                        <div className="client-card">
                            {dadosCliente ? (
                                <div className="client-details">
                                    {/* Exibe name ou nome */}
                                    <p className="client-name">
                                        {dadosCliente.name || dadosCliente.nome}
                                    </p>
                                    {/* Formata o CPF retornado do banco com a máscara */}
                                    <p className="client-cpf">
                                        {mascararCPF(dadosCliente.cpf || cpfCliente)}
                                    </p>
                                    <p className="client-phone">
                                        {dadosCliente.phone}
                                    </p>
                                    <p className="client-email">
                                        {dadosCliente.email}
                                    </p>
                                </div>
                            ) : (
                                <span className="client-placeholder">Nenhum cliente selecionado</span>
                            )}
                        </div>

                        <form onSubmit={buscarClientePorCpf} className="client-form">
                            <input
                                type="text"
                                className="client-input"
                                placeholder="000.000.000-00"
                                value={cpfCliente}
                                maxLength={14}
                                onChange={(e) => setCpfCliente(mascararCPF(e.target.value))}
                                disabled={carregando}
                            />

                            <button type="submit" className="client-btn" disabled={carregando}>
                                {carregando ? 'Buscando...' : 'Consultar'}
                            </button>       
                        </form>
                    </aside>

                    <main className="main-content-panel">
                        <div className="placeholder-content">
                            <h3>Histórico de Compras / Consultas</h3>
                            <p>Os dados do histórico do cliente ou itens buscados aparecerão aqui.</p>
                        </div>
                    </main>
                </div>
            </div>
        );
    }

    export default Dashboard;
