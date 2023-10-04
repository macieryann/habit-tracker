import './App.css';
import HabitProgressBar from './components/progressbar';
import Header from './layout/header';

const App = () => {
  const habitData = [
    [true, true, false, true, true, true, true, false, false, false], // HABIT 1
    [true, false, true, false, true, true, false], // HABIT 2
    [false, true, false, false, false, true, true], // HABIT 3
  ];

  const habitNames = ['HABIT 1', 'HABIT 2', 'HABIT 3'];

  const headerStyle = {
    backgroundColor: 'aquamarine', // Replace with your desired background color
  };

  return (
    <div className="App">
      <header className="App-header" style={headerStyle}>
        <Header />
      </header>
      <main className='App-content'>
        <HabitProgressBar habitData={habitData} habitNames={habitNames} />
      </main>
    </div>
  );
};

export default App;
