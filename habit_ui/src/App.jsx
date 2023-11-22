import './App.css';
import HabitProgressBar from './components/progressbar';
import Header from './layout/header.jsx';

const App = () => {
  return (
    <div className="App">
      <header className="App-header">
        <Header />
      </header>
      <main className='App-content'>
        <HabitProgressBar />
      </main>
    </div>
  );
};

export default App;
