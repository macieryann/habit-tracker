import './App.css';
import HabitProgressBar from './components/progressbar';
import Header from './layout/header.jsx';

const App = () => {
  const completion = [
    [true, true, false, true, true, true, true], // HABIT 1
    [true, false, true, false, true, true, false], // HABIT 2
    [false, true, false, false, false, true, true], // HABIT 3
    [true, true, true, false, true, true, true],
    [false, true, false, false, false, true, true]
  ];

  return (
    <div className="App">
      <header className="App-header">
        <Header />
      </header>
      <main className='App-content'>
        <HabitProgressBar habitData={completion} />
      </main>
    </div>
  );
};

export default App;
