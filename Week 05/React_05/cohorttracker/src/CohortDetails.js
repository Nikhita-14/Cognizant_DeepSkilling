import React from 'react';
// 1. Import the CSS Module stylesheet
import styles from './CohortDetails.module.css';

function CohortDetails({ cohort }) {
  // 2. Setup conditional logic for the header text color
  const headerColor = cohort.status.toLowerCase() === 'ongoing' ? 'green' : 'blue';

  return (
    // 3. Attach the box class using the styles object
    <div className={styles.box}>
      {/* 4. Apply the dynamic inline color configuration */}
      <h3 style={{ color: headerColor }}>
        {cohort.cohortCode} - {cohort.program}
      </h3>
      
      <dl>
        <dt>Started On</dt>
        <dd>{cohort.startDate}</dd>
        
        <dt>Current Status</dt>
        <dd>{cohort.status}</dd>
        
        <dt>Coach</dt>
        <dd>{cohort.coach}</dd>
        
        <dt>Trainer</dt>
        <dd>{cohort.trainer}</dd>
      </dl>
    </div>
  );
}

export default CohortDetails;