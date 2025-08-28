import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Layout from "./Layout";
import HomePage from "./pages/HomePage";
import PlayersPage from "./pages/PlayersPage";
import TeamsPage from "./pages/TeamsPage";

export default function App() {
  return (
    <Router>
      <Layout>
        <Routes>
          <Route path="/" element={<HomePage />} />
          <Route path="/players" element={<PlayersPage />} />
          <Route path="/teams" element={<TeamsPage />} />
          <Route path="/compare" element={<div>Compare Page (Coming Soon)</div>} />
        </Routes>
      </Layout>
    </Router>
  );
}
