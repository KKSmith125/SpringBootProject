import {authenticate, unauthenticate} from '../components/slices/userSlice';
import store from '../store.js';
import axios from 'axios';

axios.defaults.baseURL = 'http://localhost:8080';

const login = async (email, password) => {
  try {
    const response = await axios.post('/users/login', {email, password});

    store.dispatch(authenticate(response.data));

    console.log('Successfully logged in:', response.data);
  }
  catch (error) {
    console.error('Failed login:', error.response?.data);
    store.dispatch(unauthenticate);
  }
};

export {login};