import React from 'react';
import { CalculateScore } from './Components/CalculateScore';

function App() {
  return (
    <div>
      {/* Invoking the functional component with required props */}
      <CalculateScore 
        Name="John Doe" 
        School="Cognizant Academy" 
        Total={280} 
        goal={5} 
      />
    </div>
  );
}

export default App;