import { Navigate } from "react-router-dom";

const ProtectedRoute = ({ children }) => {

    const isAuthenticated = localStorage.getItem('usuarioLogado') === 'true';

    if (!isAuthenticated){
        return <Navigate to="/" replace />;
    }   
    return children; 
};

export default ProtectedRoute;