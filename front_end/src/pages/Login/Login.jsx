import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import axios from 'axios';
import './Login.css';

function Login() {
  const [matricula, setMatricula] = useState('');
  const [carregando, setCarregando] = useState(false);
  const navigate = useNavigate();

  const verificarAcesso = async () => {
    if (!matricula) return alert("Por favor, digite a matrícula!");

    setCarregando(true);
    try {
      const response = await axios.post('http://localhost:8080/api/login', {
        matricula: matricula
      });

      if (response.data.permitido) {
        sessionStorage.setItem('usuarioLogado', 'true');
        sessionStorage.setItem('nomeFuncionario', response.data.funcionario)
        navigate('/Dashboard');
      }
    } catch (error) {
      if (error.response && error.response.status === 401) {
        alert('Matrícula não cadastrada no sistema!');
      } else {
        alert('Erro de conexão com o servidor. Verifique se o Java está rodando.');
      }
    } finally {
      setCarregando(false);
    }
  };

  return (
    <div className='login-screen'>
      <form
        className='login-box'
        onSubmit={(e) => {
          e.preventDefault();
          verificarAcesso();
        }}>
        <h2 className='login-title'>Farma Aura</h2>
        <p className='login-subtitle'>aqui tem medicamento para recuperar sua aura</p>

        <input
          autoFocus
          type="text"
          placeholder="Digite sua Matrícula"
          className='login-input'
          value={matricula}
          onChange={(e) => setMatricula(e.target.value)}
        />

        <button
          type="submit"
          className='login-button'
          disabled={carregando}
        >
          {carregando ? (<span>Verificando<span className='loading-dots'></span></span> ) : ('Entrar')}
        </button>
      </form>
    </div>
  );
}

export default Login;