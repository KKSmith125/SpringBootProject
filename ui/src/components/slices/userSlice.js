import {createSlice} from '@reduxjs/toolkit';

const userSlice = createSlice({
  name: 'user',
  initialState: {
    isAuthenticated: false,
    user: null
  },
  reducers: {
    authenticate: (state, action) => {
      state.isAuthenticated = true;
      state.user = action.payload;
    },
    unauthenticate: (state, action) => {
      state.isAuthenticated = false;
      state.user = null;
    },
  },
});

export const {authenticate, unauthenticate} = userSlice.actions;
export default userSlice.reducer;