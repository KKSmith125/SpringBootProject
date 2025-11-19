import {createSlice} from '@reduxjs/toolkit';

const userSlice = createSlice({
  name: 'user',
  initialState: {
    isAuthenticated: false,
    user: null,
    token: null
  },
  reducers: {
    authenticate: (state, action) => {
      state.isAuthenticated = true;
      state.user = action.payload.user;
      state.token = action.payload.token;
    },
    unauthenticate: (state, action) => {
      state.isAuthenticated = false;
      state.user = null;
      state.token = null;
    },
  },
});

export const {authenticate, unauthenticate} = userSlice.actions;
export default userSlice.reducer;