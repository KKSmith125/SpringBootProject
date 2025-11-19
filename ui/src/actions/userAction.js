import {authenticate, unauthenticate} from '../components/slices/userSlice';
import store from '../store.js';
import axios from 'axios';

axios.defaults.baseURL = 'http://localhost:8080';

const login = async (email, password) => {
  try {
    const response = await axios.post('/users/login', {email, password});

    const {token, user} = response.data;

    localStorage.setItem('token', token);

    store.dispatch(authenticate(user));

    console.log('Successfully logged in:', user);
  }
  catch (error) {
    console.error('Failed login:', error.response?.data || error.message);
    store.dispatch(unauthenticate);
  }
};

export {login};