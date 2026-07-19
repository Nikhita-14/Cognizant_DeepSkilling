import React from 'react';
import { mount, shallow } from 'enzyme';
import CohortDetails from './CohortDetails'; // Adjust paths based on folder structure
import { CohortData } from './Cohort';       // Adjust paths based on folder structure

describe('Cohort Details Component', () => {
  // Select a mock cohort dataset from your array to use across prop assertions
  const mockCohort = CohortData[0];

  // Test - 1: Should create the component
  test('should create the component', () => {
    const wrapper = shallow(<CohortDetails cohort={mockCohort} />);
    expect(wrapper.exists()).toBe(true);
  });

  // Test - 2: Should initialize the props
  test('should initialize the props', () => {
    const wrapper = mount(<CohortDetails cohort={mockCohort} />);
    expect(wrapper.props().cohort).toEqual(mockCohort);
  });

  // Test - 3: Should display cohort code in h3
  test('should display cohort code in h3', () => {
    const wrapper = mount(<CohortDetails cohort={mockCohort} />);
    const h3Element = wrapper.find('h3');
    
    // Asserts that the rendered h3 text contains the code assigned to the props
    expect(h3Element.text()).toContain(mockCohort.code); 
  });

  // Test - 4: Should always render same html
  test('should always render same html', () => {
    const wrapper = shallow(<CohortDetails cohort={mockCohort} />);
    expect(wrapper).toMatchSnapshot();
  });
});