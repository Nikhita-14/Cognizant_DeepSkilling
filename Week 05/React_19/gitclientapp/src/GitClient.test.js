import axios from 'axios';
import GitClient from './GitClient';

// Directs Jest to mock the entire axios module implementation layer
jest.mock('axios');

describe('Git Client Tests', () => {
  test('should return repository names for techiesyed', async () => {
    // Arrange: Establish the dummy response payload to mock the axios call
    const dummyRepos = {
      data: [
        { name: 'appcentricsolutions' },
        { name: 'ArrayListDemo' },
        { name: 'CleanArchitecture' }
      ]
    };
    
    // Configures the mock implementation behavior to return the dummy payload as a resolved promise
    axios.get.mockResolvedValue(dummyRepos);

    // Act: Invoke the target static helper function 
    const response = await GitClient.getRepositories('techiesyed');

    // Assert: Verify that the function maps accurately against the mocked response structure
    expect(response.data).toEqual(dummyRepos.data);
    expect(response.data.length).toBe(3);
    
    // Optional check verifying the call destination rules were correctly hit
    expect(axios.get).toHaveBeenCalledWith('https://api.github.com/users/techiesyed/repos');
  });
});