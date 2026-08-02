import React, { useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";
import './Dashboard.css';

function Dashboard() {
    const [cpfCliente, setCpfCliente] = useState('');
    const [dadosCliente, setDadosCliente] = useState(null);
    const [carregando, setCarregando] = useState(false);
    const navigate = useNavigate();

    const buscarClientePorCpf = async (e) => {
        if (e) e.preventDefault();

        const cpfLimpo = cpfCliente.trim();
        if (!cpfLimpo) return alert("Por favor, digite o CPF do cliente!");

        setCarregando(true);
        setDadosCliente(null);

        try {
            const response = await axios.get(`http://localhost:8080/client/${cpfLimpo}`);
            setDadosCliente(response.data);
        } catch (error) {
            if (error.response && error.response.status === 404) {
                alert('Cliente não encontrado com o CPF informado!');
            } else {
                alert('Erro ao buscar cliente. Verifique se a API Spring Boot está rodando.');
            }
        } finally {
            setCarregando(false);
        }
    };

    return (
        <aside className="client-panel">
            {/* Card Superior: Exibição dos dados do Cliente */}
            <div className="client-card">
                {dadosCliente ? (
                    <div className="client-details">
                        <p className="client-name">{dadosCliente.name}</p>
                        <p className="client-cpf">{dadosCliente.cpf}</p>
                    </div>
                ) : (
                    <span className="client-placeholder">Nenhum cliente selecionado</span>
                )}
            </div>

            {/* Formulário de Busca */}
            <form onSubmit={buscarClientePorCpf} className="client-form">
                <input
                    type="text"
                    className="client-input"
                    placeholder="000.000.000-00"
                    value={cpfCliente}
                    onChange={(e) => setCpfCliente(e.target.value)}
                    disabled={carregando}
                />

                <button type="submit" className="client-btn" disabled={carregando}>
                    {carregando ? 'Buscando...' : 'Consultar'}
                </button>
            </form>
        </aside>
    );
}

export default Dashboard;